package com.sergey.stackoverflowtest.search.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sergey.stackoverflowtest.R;

/**
 * Created by smilevkiy on 28.11.17.
 */

public class AnswerViewHolder extends RecyclerView.ViewHolder {
    CardView cv;
    TextView displayName;
    TextView personAge;
    ImageView personPhoto;

    AnswerViewHolder(View itemView) {
        super(itemView);
        cv = itemView.findViewById(R.id.card_view);
        displayName = itemView.findViewById(R.id.person_name);
        personAge = itemView.findViewById(R.id.person_age);
        personPhoto = itemView.findViewById(R.id.person_photo);
    }
}
