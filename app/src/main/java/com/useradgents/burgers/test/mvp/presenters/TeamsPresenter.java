package com.useradgents.burgers.test.mvp.presenters;

import com.useradgents.burgers.test.app.FootApp;
import com.useradgents.burgers.test.managers.FootManager;
import com.useradgents.burgers.test.mvp.FootService;
import com.useradgents.burgers.test.mvp.models.LeagueTable;
import com.useradgents.burgers.test.mvp.models.Teams;
import com.useradgents.burgers.test.mvp.views.TeamsBaseMvpView;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Sofien on 25/09/2017.
 */

public class TeamsPresenter implements Presenter<TeamsBaseMvpView> {

    @Inject
    FootManager mFootManager;

    @Inject
    FootService mFootService;

    private TeamsBaseMvpView view;

    private Subscription subscription;

    @Inject
    public TeamsPresenter() {
        FootApp.getAppComponent().inject(this);
    }

    @Override
    public void attachView(TeamsBaseMvpView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadTeams(String teamsId) {

        subscription = mFootService.getTeamsCompetitions(teamsId)
                .doOnNext(this::setTeams)
                .flatMap(teams -> mFootService.getLeagueTable(teamsId))
                .doOnNext(this::setLeagueTable)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(leagueTable -> view.showTeams(), Throwable::printStackTrace);
    }

    private void setLeagueTable(LeagueTable leagueTable) {
        mFootManager.setLeagueTable(leagueTable);
    }

    private void setTeams(Teams teams) {
        mFootManager.setTeams(teams);
    }
}
