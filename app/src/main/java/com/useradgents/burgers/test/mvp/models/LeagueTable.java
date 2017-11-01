package com.useradgents.burgers.test.mvp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sofien on 29/09/2017.
 */

public class LeagueTable {

    @SerializedName("leagueCaption")
    public String leagueCaption;

    @SerializedName("matchday")
    public int matchday;

    @SerializedName("standing")
    public List<Team> standing;


    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public List<Team> getStanding() {
        return standing;
    }

    public void setStanding(List<Team> standing) {
        this.standing = standing;
    }
}
