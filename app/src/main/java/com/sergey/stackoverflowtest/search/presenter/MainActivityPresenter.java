package com.sergey.stackoverflowtest.search.presenter;

import com.sergey.stackoverflowtest.BasePresenter;
import com.sergey.stackoverflowtest.UI;
import com.sergey.stackoverflowtest.dto.QuestionDto;
import com.sergey.stackoverflowtest.stackapi.QuestionApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sergey on 27.11.17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityPresenter.MainActivityUI> {

    private final QuestionApi questionApi;
    private Disposable dis;

    @Inject
    public MainActivityPresenter(QuestionApi questionApi) {
        this.questionApi = questionApi;
    }

    @Override
    public void attacheUI(MainActivityUI ui) {
        super.attacheUI(ui);
    }

    @Override
    public void detachUI() {
        super.detachUI();
        if (dis != null) {
            dis.dispose();
        }
    }


    public void startSearch(CharSequence charSequence) {
        dis = questionApi.searchByTitle(charSequence.toString(), "votes", "asc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(items -> Observable.fromIterable(items.getItems()))
                .map(QuestionDto::new)
                .toList()
                .subscribe(dtos -> ui.showResultOfSearch(dtos));

    }

    public interface MainActivityUI extends UI {

        void showResultOfSearch(List<QuestionDto> questionDtos);
    }
}
