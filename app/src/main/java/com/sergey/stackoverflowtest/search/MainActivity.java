package com.sergey.stackoverflowtest.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sergey.stackoverflowtest.MyApplication;
import com.sergey.stackoverflowtest.R;
import com.sergey.stackoverflowtest.search.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.MainActivityUI{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
