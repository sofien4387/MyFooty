package com.useradgents.burgers.test.mvp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sofien on 26/09/2017.
 */

public class Team {

    @SerializedName("id")
    public int id;

    @SerializedName("points")
    public int points;

    @SerializedName("rank")
    public int rank;

    @SerializedName("goals")
    public int goals;

    @SerializedName("goalsAgainst")
    public int goalsAgainst;

    @SerializedName("goalDifference")
    public int goalDifference;

    @SerializedName("teamId")
    public int teamId;

    @SerializedName("team")
    public String team;

    @SerializedName("playedGames")
    public int playedGames;

    @SerializedName("name")
    public String name;

    @SerializedName("shortName")
    public String shortName;

    @SerializedName("squadMarketValue")
    public String squadMarketValue;

    @SerializedName("crestUrl")
    public String crestUrl;

    @SerializedName("crestURI")
    public String crestURI;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }
}
