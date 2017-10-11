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

public class NumbersActivity extends AppCompatActivity {

    private final List<WordView> wordViews = Arrays.asList(
            new WordView("one", "lutti", R.drawable.number_one),
            new WordView("two", "ottiko", R.drawable.number_two),
            new WordView("three", "tolookosu", R.drawable.number_three),
            new WordView("four", "oyyisa", R.drawable.number_four),
            new WordView("five", "massoka", R.drawable.number_five),
            new WordView("six", "temmoka", R.drawable.number_six),
            new WordView("seven", "kenekaku", R.drawable.number_seven),
            new WordView("eight", "kawinta", R.drawable.number_eight),
            new WordView("nine", "wo'e", R.drawable.number_nine),
            new WordView("ten", "na'aacha", R.drawable.number_ten)
    );

    private final int[] wordMedia = {
            R.raw.number_one, R.raw.number_two, R.raw.number_three,
            R.raw.number_four, R.raw.number_five, R.raw.number_six,
            R.raw.number_seven, R.raw.number_eight, R.raw.number_nine,
            R.raw.number_ten
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

        WordViewAdapter wordViewAdapter = new WordViewAdapter(this, wordViews, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordViewAdapter);

        // set sound
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, wordMedia[position]);
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
