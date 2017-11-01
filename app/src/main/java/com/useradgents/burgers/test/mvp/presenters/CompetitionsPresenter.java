package com.useradgents.burgers.test.mvp.presenters;

import com.useradgents.burgers.test.app.FootApp;
import com.useradgents.burgers.test.managers.FootManager;
import com.useradgents.burgers.test.mvp.FootService;
import com.useradgents.burgers.test.mvp.models.Competition;
import com.useradgents.burgers.test.mvp.views.CompetitionsBaseMvpView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Sofien on 25/09/2017.
 */

public class CompetitionsPresenter implements Presenter<CompetitionsBaseMvpView> {

    @Inject
    FootService mFootService;

    @Inject
    FootManager mFootManager;

    private CompetitionsBaseMvpView view;

    private Subscription subscription;

    @Inject
    public CompetitionsPresenter() {
        FootApp.getAppComponent().inject(this);
    }

    @Override
    public void attachView(CompetitionsBaseMvpView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadCompetitions() {

        Observable<List<Competition>> observable = mFootService.getCompetitions();

        view.onProgressIndicator(true);

        subscription = observable.observeOn(AndroidSchedulers.mainThread())
                .doOnNext(competitionList -> mFootManager.setCompetitions(competitionList))
                .subscribe(competitions -> {
                    view.onProgressIndicator(false);
                    view.showCompetitions();
                }, Throwable::printStackTrace);
    }
}
