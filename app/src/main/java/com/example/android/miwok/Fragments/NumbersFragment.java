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

public class NumbersFragment extends Fragment {

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

    public NumbersFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        WordViewAdapter wordViewAdapter = new WordViewAdapter(getContext(), wordViews, R.color.category_numbers);
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
