package com.example.android.miwok.Activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.miwok.ListViewUtilities.OnItemClickListener;
import com.example.android.miwok.R;
import com.example.android.miwok.ListViewUtilities.WordView;
import com.example.android.miwok.ListViewUtilities.WordViewAdapter;

import java.util.Arrays;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    private final List<WordView> wordViews = Arrays.asList(
            new WordView("red", "weṭeṭṭi", R.drawable.color_red),
            new WordView("green", "chokokki", R.drawable.color_green),
            new WordView("brown", "ṭakaakki", R.drawable.color_brown),
            new WordView("gray", "ṭopoppi", R.drawable.color_gray),
            new WordView("black", "kululli", R.drawable.color_black),
            new WordView("white", "kelelli", R.drawable.color_white),
            new WordView("dusty yellow" ,"ṭopiisә", R.drawable.color_dusty_yellow),
            new WordView("mustard yellow" ,"chiwiiṭә", R.drawable.color_mustard_yellow)
    );

    private final int[] wordMedia = {
            R.raw.color_red, R.raw.color_green, R.raw.color_brown, R.raw.color_gray, R.raw.color_black,
            R.raw.color_white, R.raw.color_dusty_yellow, R.raw.color_mustard_yellow
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

        WordViewAdapter wordViewAdapter = new WordViewAdapter(
                this, wordViews, R.color.category_colors
        );
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordViewAdapter);
        listView.setOnItemClickListener(new OnItemClickListener(this, wordMedia));

    }

}
