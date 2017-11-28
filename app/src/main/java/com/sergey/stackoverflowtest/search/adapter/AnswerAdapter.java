package com.sergey.stackoverflowtest.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergey.stackoverflowtest.R;
import com.sergey.stackoverflowtest.dto.QuestionDto;

import java.util.List;

/**
 * Created by smilevkiy on 28.11.17.
 */

public class AnswerAdapter extends RecyclerView.Adapter<AnswerViewHolder> {

    private List<QuestionDto> questions;

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder answerViewHolder, int position) {
        QuestionDto questionDto = questions.get(position);
        answerViewHolder.displayName.setText(questionDto.getDisplayName());


    }

    @Override
    public int getItemCount() {
        return questions == null ? 0 : questions.size();
    }

    public void setData(List<QuestionDto> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }


}
