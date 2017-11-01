package com.useradgents.burgers.test.mvp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sofien on 26/09/2017.
 */

public class Teams {

    @SerializedName("count")
    public int count;

    @SerializedName("teams")
    public List<Team> teamList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
