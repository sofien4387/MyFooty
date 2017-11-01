package com.useradgents.burgers.test.mvp;

import com.arellomobile.mvp.sample.github.BuildConfig;
import com.useradgents.burgers.test.app.NewsApi;
import com.useradgents.burgers.test.mvp.models.Posts;

import rx.Observable;


public class NewsService {

    private NewsApi mBurgerApi;

    public NewsService(NewsApi githubApi) {
        mBurgerApi = githubApi;
    }

    public Observable<Posts> getPosts(String query) {
        return mBurgerApi.getPosts(BuildConfig.TOKEN, query, BuildConfig.FORMAT, BuildConfig.LANGUAGE);
    }
}
