package com.sergey.stackoverflowtest.search.presenter;

import com.sergey.stackoverflowtest.BasePresenter;
import com.sergey.stackoverflowtest.UI;
import com.sergey.stackoverflowtest.dto.QuestionDto;
import com.sergey.stackoverflowtest.facade.FacadeRequest;
import com.sergey.stackoverflowtest.stackapi.pojo.Question;
import com.sergey.stackoverflowtest.stackapi.pojo.StackResponse;

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

    private final FacadeRequest facadeRequest;
    private Disposable dis;

    @Inject
    public MainActivityPresenter(FacadeRequest facadeRequest) {
        this.facadeRequest = facadeRequest;
    }

    @Override
    public void attacheUI(MainActivityUI ui) {
        super.attacheUI(ui);
        Observable<StackResponse<Question>> observable = facadeRequest.getLatestObservable();
        if (observable != null) {
            handleRequest(observable);
        }
    }

    @Override
    public void detachUI() {
        super.detachUI();
        if (dis != null) {
            dis.dispose();
        }
    }

    public void startSearch(CharSequence charSequence) {
        handleRequest(facadeRequest.searchRequest(charSequence));
    }

    private void handleRequest(Observable<StackResponse<Question>> observable) {
        if (observable == null && ui != null) {
            ui.showAlert();
            return;
        }
        dis = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(items -> Observable.fromIterable(items.getItems()))
                .map(QuestionDto::new)
                .toList()
                .subscribe(dtos -> ui.showResultOfSearch(dtos), throwable -> {
                    if (ui != null && facadeRequest.getLatestObservable() != null) {
                        ui.showToast();
                        handleRequest(facadeRequest.getLatestObservable());
                    }
                    if (ui != null) {
                        ui.showAlert();
                    }

                });
    }

    public interface MainActivityUI extends UI {

        void showResultOfSearch(List<QuestionDto> questionDtos);

        void showAlert();

        void showToast();
    }
}
