package com.example.android.miwok.Activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.WordView;
import com.example.android.miwok.WordViewAdapter;

import java.util.Arrays;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    private final List<WordView> wordViews = Arrays.asList(
        new WordView("father" ,"әpә", R.drawable.family_father),
        new WordView("mother" ,"әṭa", R.drawable.family_mother),
        new WordView("son" ,"angsi", R.drawable.family_son),
        new WordView("daughter" ,"tune", R.drawable.family_daughter),
        new WordView("older brother" ,"taachi", R.drawable.family_older_brother),
        new WordView("younger brother" ,"chalitti", R.drawable.family_younger_brother),
        new WordView("older sister" ,"teṭe", R.drawable.family_older_sister),
        new WordView("younger sister" ,"kolliti", R.drawable.family_younger_sister),
        new WordView("grandmother" ,"ama", R.drawable.family_grandmother),
        new WordView("grandfather" ,"paapa", R.drawable.family_grandfather)
    );

    private final int[] wordMedia = {
            R.raw.family_father, R.raw.family_mother, R.raw.family_son,
            R.raw.family_daughter, R.raw.family_older_brother, R.raw.family_younger_brother,
            R.raw.family_older_sister, R.raw.family_younger_sister,
            R.raw.family_grandmother, R.raw.family_grandfather
    };

    private MediaPlayer mediaPlayer;

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        WordViewAdapter wordViewAdapter = new WordViewAdapter(this, wordViews, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordViewAdapter);

        // set sound
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, wordMedia[position]);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });
    }
}
