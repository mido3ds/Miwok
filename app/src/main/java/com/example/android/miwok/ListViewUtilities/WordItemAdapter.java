package com.example.android.miwok.ListViewUtilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.Words.Word;

public class WordItemAdapter extends ArrayAdapter<Word> {
    private final int colorId;

    public WordItemAdapter(@NonNull Context context, @NonNull Word[] objects, int colorId) {
        super(context, R.layout.item_of_list_words, objects);
        this.colorId = colorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_of_list_words, null);
        }

        Word word = getItem(position);
        TextView miwokTextView = (TextView) view.findViewById(R.id.miwok_word);
        TextView englishTextView = (TextView) view.findViewById(R.id.english_word);
        ImageView iconImageView = (ImageView) view.findViewById(R.id.thumb);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.linear_sub_list);

        frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), colorId));
        miwokTextView.setText(word.getMiwokTranslation());
        englishTextView.setText(word.getDefaultTranslation());
        if (word.hasImage()) {
            iconImageView.setImageResource(word.getImageId());
        } else {
            ((LinearLayout) view).removeView(iconImageView);
        }


        return view;
    }
}
