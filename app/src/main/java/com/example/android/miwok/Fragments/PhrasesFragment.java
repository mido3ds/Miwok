package com.example.android.miwok.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.miwok.ListViewUtilities.OnItemClickListener;
import com.example.android.miwok.ListViewUtilities.WordView;
import com.example.android.miwok.ListViewUtilities.WordViewAdapter;
import com.example.android.miwok.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mido on 10/11/17.
 */

public class PhrasesFragment extends Fragment {

    private final List<WordView> wordViews = Arrays.asList(
            new WordView("Where are you going?", "minto wuksus"),
            new WordView("What is your name?", "tinnә oyaase'nә"),
            new WordView("My name is...", "oyaaset..."),
            new WordView("How are you feeling?", "michәksәs?"),
            new WordView("I’m feeling good.", "kuchi achit"),
            new WordView("Are you coming?", "әәnәs'aa?"),
            new WordView("Yes, I’m coming.", "hәә’ әәnәm"),
            new WordView("I’m coming.", "әәnәm"),
            new WordView("Let’s go.", "yoowutis"),
            new WordView("Come here.", "әnni'nem")
    );

    private final int[] wordMedia = {
            R.raw.phrase_where_are_you_going, R.raw.phrase_what_is_your_name,
            R.raw.phrase_my_name_is, R.raw.phrase_how_are_you_feeling,
            R.raw.phrase_im_feeling_good, R.raw.phrase_are_you_coming,
            R.raw.phrase_yes_im_coming, R.raw.phrase_im_coming,
            R.raw.phrase_lets_go, R.raw.phrase_come_here
    };

    public PhrasesFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        WordViewAdapter wordViewAdapter = new WordViewAdapter(getContext(), wordViews, R.color.category_phrases);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(wordViewAdapter);
        listView.setOnItemClickListener(new OnItemClickListener(getContext(), wordMedia));

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
