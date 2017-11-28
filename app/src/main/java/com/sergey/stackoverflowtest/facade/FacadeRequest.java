package com.sergey.stackoverflowtest.facade;

import com.sergey.stackoverflowtest.dto.QuestionDto;
import com.sergey.stackoverflowtest.stackapi.QuestionApi;
import com.sergey.stackoverflowtest.stackapi.pojo.Question;
import com.sergey.stackoverflowtest.stackapi.pojo.StackResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by sergey on 28.11.17.
 */

@Singleton
public class FacadeRequest {

    private final QuestionApi questionApi;
    private StackResponse<Question> stackResponse;

    @Inject
    public FacadeRequest(QuestionApi questionApi) {
        this.questionApi = questionApi;
    }


    public Observable<StackResponse<Question>> getLatestObservable(){
        if(stackResponse != null) {
            return Observable.just(stackResponse);
        }
        return null;
    }


    public Observable<StackResponse<Question>> searchRequest(CharSequence charSequence){
        return questionApi.searchByTitle(charSequence.toString(), "votes", "asc")
                .doOnNext(res -> stackResponse = res);
    }
}
