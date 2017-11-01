package com.useradgents.burgers.test.mvp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Sofien on 25/09/2017.
 */

public class Competition {

    @SerializedName("id")
    public int id;

    @SerializedName("caption")
    public String caption;

    @SerializedName("league")
    public String league;

    @SerializedName("year")
    public int year;

    @SerializedName("currentMatchday")
    public int currentMatchday;

    @SerializedName("numberOfTeams")
    public int numberOfTeams;

    @SerializedName("numberOfGames")
    public int numberOfGames;

    @SerializedName("lastUpdated")
    public Date lastUpdated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(int currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
