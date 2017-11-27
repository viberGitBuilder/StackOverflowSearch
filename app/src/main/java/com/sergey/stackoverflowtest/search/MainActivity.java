package com.sergey.stackoverflowtest.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.sergey.stackoverflowtest.MyApplication;
import com.sergey.stackoverflowtest.R;
import com.sergey.stackoverflowtest.search.presenter.MainActivityPresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity implements MainActivityPresenter.MainActivityUI {

    @Inject
    MainActivityPresenter presenter;
    private EditText editText;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.search_edit_text);

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
    public void showResultOfSearch(CharSequence charSequence) {
        Toast.makeText(this, charSequence, Toast.LENGTH_SHORT).show();
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
