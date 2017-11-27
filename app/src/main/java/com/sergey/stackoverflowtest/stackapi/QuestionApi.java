package com.sergey.stackoverflowtest.stackapi;

import com.sergey.stackoverflowtest.stackapi.pojo.Question;
import com.sergey.stackoverflowtest.stackapi.pojo.StackResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sergey on 27.11.17.
 */

public interface QuestionApi {

    @GET("search?site=stackoverflow")
    Observable<StackResponse<Question>> searchByTitle(@Query("intitle") String query, @Query("sort") String sort, @Query("order") String order);
}
