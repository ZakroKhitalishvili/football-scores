package com.example.zakro.footballscores.Models;

import java.util.Date;

/**
 * Created by zakro on 12/5/17.
 */

public class Competition {
    private int id;
    private String caption;
    private String league;
    private String year;
    private int currentMatchday;
    private int numberOfMatchdays;
    private int numberOfTeams;
    private int numberOfGames;
    private Date lastUpdated;
    private LinksProvider _links;

    public LinksProvider get_links() {
        return _links;
    }

    public void set_links(LinksProvider _links) {
        this._links = _links;
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(int currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public int getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public void setNumberOfMatchdays(int numberOfMatchdays) {
        this.numberOfMatchdays = numberOfMatchdays;
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

    public class LinksProvider
    {
        public Href getSelf() {
            return self;
        }

        public void setSelf(Href self) {
            this.self = self;
        }

        public Href getTeams() {
            return teams;
        }

        public void setTeams(Href teams) {
            this.teams = teams;
        }

        public Href getFixtures() {
            return fixtures;
        }

        public void setFixtures(Href fixtures) {
            this.fixtures = fixtures;
        }

        public Href getLeagueTable() {
            return leagueTable;
        }

        public void setLeagueTable(Href leagueTable) {
            this.leagueTable = leagueTable;
        }

        private Href self;
        private Href teams;
        private Href fixtures;
        private Href leagueTable;
    }

}
