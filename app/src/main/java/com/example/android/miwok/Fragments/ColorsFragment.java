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

public class ColorsFragment extends Fragment {

    private final List<WordView> wordViews = Arrays.asList(
            new WordView("red", "weṭeṭṭi", R.drawable.color_red),
            new WordView("green", "chokokki", R.drawable.color_green),
            new WordView("brown", "ṭakaakki", R.drawable.color_brown),
            new WordView("gray", "ṭopoppi", R.drawable.color_gray),
            new WordView("black", "kululli", R.drawable.color_black),
            new WordView("white", "kelelli", R.drawable.color_white),
            new WordView("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow),
            new WordView("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow)
    );

    private final int[] wordMedia = {
            R.raw.color_red, R.raw.color_green, R.raw.color_brown, R.raw.color_gray, R.raw.color_black,
            R.raw.color_white, R.raw.color_dusty_yellow, R.raw.color_mustard_yellow
    };

    public ColorsFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        WordViewAdapter wordViewAdapter = new WordViewAdapter(
                getContext(), wordViews, R.color.category_colors
        );
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(wordViewAdapter);
        listView.setOnItemClickListener(new OnItemClickListener(getContext(), wordMedia));

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        // TODO: release mediaPlayer from OnItemClickListener
    }
}
