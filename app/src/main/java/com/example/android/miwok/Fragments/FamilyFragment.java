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

public class FamilyFragment extends Fragment {

    private final List<WordView> wordViews = Arrays.asList(
            new WordView("father", "әpә", R.drawable.family_father),
            new WordView("mother", "әṭa", R.drawable.family_mother),
            new WordView("son", "angsi", R.drawable.family_son),
            new WordView("daughter", "tune", R.drawable.family_daughter),
            new WordView("older brother", "taachi", R.drawable.family_older_brother),
            new WordView("younger brother", "chalitti", R.drawable.family_younger_brother),
            new WordView("older sister", "teṭe", R.drawable.family_older_sister),
            new WordView("younger sister", "kolliti", R.drawable.family_younger_sister),
            new WordView("grandmother", "ama", R.drawable.family_grandmother),
            new WordView("grandfather", "paapa", R.drawable.family_grandfather)
    );

    private final int[] wordMedia = {
            R.raw.family_father, R.raw.family_mother, R.raw.family_son,
            R.raw.family_daughter, R.raw.family_older_brother, R.raw.family_younger_brother,
            R.raw.family_older_sister, R.raw.family_younger_sister,
            R.raw.family_grandmother, R.raw.family_grandfather
    };

    public FamilyFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        WordViewAdapter wordViewAdapter = new WordViewAdapter(getContext(), wordViews, R.color.category_family);
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
