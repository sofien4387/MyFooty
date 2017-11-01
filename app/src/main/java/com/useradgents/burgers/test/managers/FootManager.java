package com.useradgents.burgers.test.managers;

import com.useradgents.burgers.test.app.FootApp;
import com.useradgents.burgers.test.mvp.models.Competition;
import com.useradgents.burgers.test.mvp.models.LeagueTable;
import com.useradgents.burgers.test.mvp.models.Team;
import com.useradgents.burgers.test.mvp.models.Teams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FootManager {

    private List<Integer> listCompetitions = Arrays.asList(445,455,450,452,456,464);

    private List<Competition> competitions = new ArrayList<>();

    private Teams teams;

    private LeagueTable leagueTable;

    @Inject
    public FootManager() {
        FootApp.getAppComponent().inject(this);
    }

    public void setCompetitions(List<Competition> competitions){
        for (Competition competition : competitions) {
            if(listCompetitions.contains(competition.getId())){
                this.competitions.add(competition);
            }
        }
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setTeams(Teams teams){
        this.teams = teams;
    }

    public Teams getTeamList() {
        return teams;
    }

    public LeagueTable getLeagueTable() {
        return leagueTable;
    }

    public void setLeagueTable(LeagueTable leagueTable) {
        this.leagueTable = leagueTable;
        mergeTeams(leagueTable);
    }


    private void mergeTeams(LeagueTable leagueTable) {

        ConcurrentHashMap<Integer, Team>  teamsMap = parseTeamsToMap();

        List<Team> listTeam = leagueTable.getStanding();

        for (Team team : listTeam) {
            Team t = teamsMap.get(team.teamId);
            t.setName(team.getName());
            t.setShortName(team.getShortName());
            t.setSquadMarketValue(team.getSquadMarketValue());
            t.setCrestUrl(team.getCrestUrl());
        }

        teams.setTeamList(listTeam);
    }

    private ConcurrentHashMap<Integer, Team> parseTeamsToMap() {
        ConcurrentHashMap<Integer, Team> mapTeam = new ConcurrentHashMap<>();
        for (Team team : teams.getTeamList()) {
            mapTeam.put(team.getId(), team);
        }
        return mapTeam;
    }
}
