package com.useradgents.burgers.test.app;

import com.useradgents.burgers.test.mvp.models.Competition;
import com.useradgents.burgers.test.mvp.models.LeagueTable;
import com.useradgents.burgers.test.mvp.models.Teams;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface FootApi {

    @GET("/v1/competitions/?season=2017")
    Observable<List<Competition>> getCompetitions();

    @GET("/v1/competitions/{id}/teams")
    Observable<Teams> getTeamsCompetitions(@Path("id") String id);

    @GET("/v1/competitions/{id}/leagueTable")
    Observable<LeagueTable> getLeagueTable(@Path("id") String id);
}
