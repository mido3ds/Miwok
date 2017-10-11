package com.example.android.miwok.Activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.miwok.ListViewUtilities.OnItemClickListener;
import com.example.android.miwok.ListViewUtilities.WordView;
import com.example.android.miwok.ListViewUtilities.WordViewAdapter;
import com.example.android.miwok.R;

import java.util.Arrays;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {

    private final List<WordView> wordViews = Arrays.asList(
        new WordView("Where are you going?" ,"minto wuksus"),
        new WordView("What is your name?" ,"tinnә oyaase'nә"),
        new WordView("My name is..." ,"oyaaset..."),
        new WordView("How are you feeling?" ,"michәksәs?"),
        new WordView("I’m feeling good." ,"kuchi achit"),
        new WordView("Are you coming?" ,"әәnәs'aa?"),
        new WordView("Yes, I’m coming." ,"hәә’ әәnәm"),
        new WordView("I’m coming." ,"әәnәm"),
        new WordView("Let’s go." ,"yoowutis"),
        new WordView("Come here." ,"әnni'nem")
    );

    private final int[] wordMedia = {
            R.raw.phrase_where_are_you_going, R.raw.phrase_what_is_your_name,
            R.raw.phrase_my_name_is, R.raw.phrase_how_are_you_feeling,
            R.raw.phrase_im_feeling_good, R.raw.phrase_are_you_coming,
            R.raw.phrase_yes_im_coming, R.raw.phrase_im_coming,
            R.raw.phrase_lets_go, R.raw.phrase_come_here
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

        WordViewAdapter wordViewAdapter = new WordViewAdapter(this, wordViews, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordViewAdapter);
        listView.setOnItemClickListener(new OnItemClickListener(this, wordMedia));
    }
}
