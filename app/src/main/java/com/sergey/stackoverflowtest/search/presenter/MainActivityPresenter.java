package com.sergey.stackoverflowtest.search.presenter;

import com.sergey.stackoverflowtest.BasePresenter;
import com.sergey.stackoverflowtest.UI;

import javax.inject.Inject;

/**
 * Created by sergey on 27.11.17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityPresenter.MainActivityUI> {

    @Inject
    public MainActivityPresenter() {
    }

    @Override
    public void attacheUI(MainActivityUI ui) {
        super.attacheUI(ui);
    }

    @Override
    public void detachUI() {
        super.detachUI();
    }


    public void startSearch(CharSequence charSequence){
     ui.showResultOfSearch(charSequence);
    }

    public interface MainActivityUI extends UI {


        void showResultOfSearch(CharSequence charSequence);
    }
}
