package com.example.android.miwok.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.miwok.ListViewUtilities.OnWordItemClickListener;
import com.example.android.miwok.ListViewUtilities.WordItemAdapter;
import com.example.android.miwok.R;
import com.example.android.miwok.Words.ColorWords;

public class ColorsFragment extends Fragment {
    private OnWordItemClickListener onWordItemClickListener;

    public ColorsFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_words, container, false);

        WordItemAdapter wordItemAdapter = new WordItemAdapter(
                getContext(), ColorWords.WORDS, R.color.category_colors
        );
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(wordItemAdapter);

        onWordItemClickListener = new OnWordItemClickListener(getContext(), ColorWords.WORDS);
        listView.setOnItemClickListener(onWordItemClickListener);

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        onWordItemClickListener.stopPlayingMedia();
    }
}
