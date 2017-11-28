package com.sergey.stackoverflowtest.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.sergey.stackoverflowtest.MyApplication;
import com.sergey.stackoverflowtest.R;
import com.sergey.stackoverflowtest.dto.QuestionDto;
import com.sergey.stackoverflowtest.search.adapter.AnswerAdapter;
import com.sergey.stackoverflowtest.search.presenter.MainActivityPresenter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity implements MainActivityPresenter.MainActivityUI {

    @Inject
    MainActivityPresenter presenter;
    private EditText editText;
    private Disposable disposable;
    private AnswerAdapter answerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.search_edit_text);
        RecyclerView recyclerView = findViewById(R.id.questions_list);
        answerAdapter = new AnswerAdapter();
        recyclerView.setAdapter(answerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.attacheUI(this);
        disposable = RxTextView.textChanges(editText)
                .debounce(1L, TimeUnit.SECONDS)
                .filter(charSequence -> charSequence.length() > 3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(sequence -> presenter.startSearch(sequence));

    }

    @Override
    public void showResultOfSearch(List<QuestionDto> list) {
        answerAdapter.setData(list);
    }

    @Override
    protected void onPause() {
        presenter.detachUI();
        if (disposable != null) {
            disposable.dispose();
        }
        super.onPause();

    }
}
