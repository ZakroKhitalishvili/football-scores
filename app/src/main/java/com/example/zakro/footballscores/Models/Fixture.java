package com.example.zakro.footballscores.Models;

import java.util.Date;

/**
 * Created by zakro on 12/5/17.
 */

public class Fixture
{
    private Date date;
    private String status;
    private int matchday;
    private String homeTeamName;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public LinksProvider get_links() {
        return _links;
    }

    public void set_links(LinksProvider _links) {
        this._links = _links;
    }

    private String awayTeamName;
    private Result result;
    private Fixture.LinksProvider _links;

    public class Result
    {
        private int goalsHomeTeam;

        public int getGoalsHomeTeam() {
            return goalsHomeTeam;
        }

        public void setGoalsHomeTeam(int goalsHomeTeam) {
            this.goalsHomeTeam = goalsHomeTeam;
        }

        public int getGoalsAwayTeam() {
            return goalsAwayTeam;
        }

        public void setGoalsAwayTeam(int goalsAwayTeam) {
            this.goalsAwayTeam = goalsAwayTeam;
        }

        public Result getHalfTime() {
            return halfTime;
        }

        public void setHalfTime(Result halfTime) {
            this.halfTime = halfTime;
        }

        private int goalsAwayTeam;
        private Result halfTime;
    }

    public class LinksProvider
    {
        private Href self;
        private  Href competition;

        public Href getSelf() {
            return self;
        }

        public void setSelf(Href self) {
            this.self = self;
        }

        public Href getCompetition() {
            return competition;
        }

        public void setCompetition(Href competition) {
            this.competition = competition;
        }

        public Href getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(Href homeTeam) {
            this.homeTeam = homeTeam;
        }

        public Href getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(Href awayTeam) {
            this.awayTeam = awayTeam;
        }

        private Href homeTeam;
        private Href awayTeam;

    }


}
