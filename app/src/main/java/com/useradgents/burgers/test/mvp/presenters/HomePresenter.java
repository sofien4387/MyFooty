package com.useradgents.burgers.test.mvp.presenters;

import com.useradgents.burgers.test.app.FootApp;
import com.useradgents.burgers.test.mvp.NewsService;
import com.useradgents.burgers.test.mvp.models.Posts;
import com.useradgents.burgers.test.mvp.views.MainBaseMvpView;
import com.useradgents.burgers.test.managers.NewsManager;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class HomePresenter implements Presenter<MainBaseMvpView> {

    @Inject
    NewsService mNewsService;

    @Inject
    NewsManager mNewsManager;

    private MainBaseMvpView mainMvpView;
    private Subscription subscription;

    @Inject
    public HomePresenter() {
        FootApp.getAppComponent().inject(this);
    }

    @Override
    public void attachView(MainBaseMvpView view) {
        this.mainMvpView = view;
    }

    @Override
    public void detachView() {
        this.mainMvpView = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadRepositories() {

        Observable<Posts> observable = mNewsService.getPosts("fcb barcelone");

        mainMvpView.onProgressIndicator(true);

        subscription = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts -> {
                    mainMvpView.onProgressIndicator(false);
                    mNewsManager.setPosts(posts);
                    mainMvpView.showRepositories(posts);

        }, Throwable::printStackTrace);
    }
}
