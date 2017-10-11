package com.example.android.miwok.ListViewUtilities;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;
import static android.media.AudioManager.AUDIOFOCUS_REQUEST_GRANTED;

public class OnItemClickListener implements AdapterView.OnItemClickListener {

    private final Context context;
    private final int wordMedia[];
    private final AudioManager audioManager;
    private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    };
    private MediaPlayer mediaPlayer;
    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Permanent loss of audio focus
                // Pause playback immediately
                mediaPlayer.stop();
                mediaPlayer.release();
            } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                // Pause playback
                mediaPlayer.pause();
            } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Lower the volume, keep playing
                int MAX_VOLUME = 100;
                int soundVolume = 50;
                float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
                mediaPlayer.setVolume(volume, volume);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Your app has been granted audio focus again
                // Raise volume to normal, restart playback if necessary
                int MAX_VOLUME = 100;
                int soundVolume = 100;
                float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
                mediaPlayer.setVolume(volume, volume);
            }
        }

    };

    public OnItemClickListener(Context context, int[] wordMedia) {
        this.context = context;
        this.wordMedia = wordMedia;

        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        mediaPlayer = MediaPlayer.create(context, wordMedia[position]);

        // get audio focus
        int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (result == AUDIOFOCUS_REQUEST_GRANTED) {

            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(onCompletionListener);

        } else {
            Log.e("AudioFocus", "AudioFocus is not granted, cant play sound");
        }

    }

}
