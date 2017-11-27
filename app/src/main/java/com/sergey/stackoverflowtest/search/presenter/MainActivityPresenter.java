package com.sergey.stackoverflowtest.search.presenter;

import com.sergey.stackoverflowtest.BasePresenter;
import com.sergey.stackoverflowtest.UI;

/**
 * Created by sergey on 27.11.17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityPresenter.MainActivityUI> {


    @Override
    public void attacheUI(MainActivityUI ui) {
        super.attacheUI(ui);
    }

    @Override
    public void detachUI() {
        super.detachUI();
    }

    public interface MainActivityUI extends UI {

    }
}
