package com.useradgents.burgers.test.mvp;

import com.useradgents.burgers.test.app.FootApi;
import com.useradgents.burgers.test.mvp.models.Competition;
import com.useradgents.burgers.test.mvp.models.LeagueTable;
import com.useradgents.burgers.test.mvp.models.Teams;

import java.util.List;

import rx.Observable;


public class FootService {

    private FootApi mFootApi;

    public FootService(FootApi footApi) {
        mFootApi = footApi;
    }

    public Observable<List<Competition>> getCompetitions() {
        return mFootApi.getCompetitions();
    }

    public Observable<Teams> getTeamsCompetitions(String id) {
        return mFootApi.getTeamsCompetitions(id);
    }

    public Observable<LeagueTable> getLeagueTable(String id) {
        return mFootApi.getLeagueTable(id);
    }
}
