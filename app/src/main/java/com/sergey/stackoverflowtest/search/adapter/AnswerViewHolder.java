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

public class AnswerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    CardView cardView;
    TextView title;
    TextView name;
    ImageView personPhoto;
    String url;
    AnswerAdapter.CardClickListener cardClickListener;

    AnswerViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view);
        title = itemView.findViewById(R.id.title);
        name = itemView.findViewById(R.id.name);
        personPhoto = itemView.findViewById(R.id.person_photo);
        cardView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(cardClickListener != null){
            cardClickListener.onCardClick(url);
        }
    }
}
