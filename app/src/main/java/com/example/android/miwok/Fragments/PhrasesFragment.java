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
import com.example.android.miwok.Words.PhraseWords;

/**
 * Created by Mido on 10/11/17.
 */

public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        WordItemAdapter wordItemAdapter = new WordItemAdapter(getContext(), PhraseWords.words, R.color.category_phrases);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(wordItemAdapter);
        listView.setOnItemClickListener(new OnWordItemClickListener(getContext(), PhraseWords.words));

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
