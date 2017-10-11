package com.example.android.miwok.ListViewUtilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.miwok.R;

import java.util.List;

public class WordViewAdapter extends ArrayAdapter<WordView> {
    private final int colorId;

    public WordViewAdapter(@NonNull Context context, @NonNull List<WordView> objects, int colorId) {
        super(context, R.layout.list_item, objects);
        this.colorId = colorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.list_item, null);
        }

        WordView wordView = getItem(position);
        TextView miwokTextView = (TextView) view.findViewById(R.id.miwok_word);
        TextView englishTextView = (TextView) view.findViewById(R.id.english_word);
        ImageView iconImageView = (ImageView) view.findViewById(R.id.thumb);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear_sub_list);

        linearLayout.setBackgroundColor(ContextCompat.getColor(getContext(), colorId));
        miwokTextView.setText(wordView.getMiwokTranslation());
        englishTextView.setText(wordView.getDefaultTranslation());
        if (wordView.hasImage()) {
            iconImageView.setImageResource(wordView.getImageId());
        } else {
            ((LinearLayout) view).removeView(iconImageView);
        }


        return view;
    }
}