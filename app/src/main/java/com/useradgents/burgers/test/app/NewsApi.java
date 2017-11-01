package com.useradgents.burgers.test.app;

import com.useradgents.burgers.test.mvp.models.Posts;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface NewsApi {

    @GET("/filterWebContent")
    Observable<Posts> getPosts(@Query("token") String token, @Query("q") String query, @Query("format") String format ,@Query("language") String language);
}
