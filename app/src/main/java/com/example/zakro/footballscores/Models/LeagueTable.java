package com.example.zakro.footballscores.Models;

/**
 * Created by zakro on 12/5/17.
 */

public class LeagueTable
{
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

    private String leagueCaption;
    private int matchday;

    public StandingTeam[] getStanding() {
        return standing;
    }

    public void setStanding(StandingTeam[] standing) {
        this.standing = standing;
    }

    private StandingTeam[] standing;

    public class StandingTeam
    {
        private int position;
        private String teamName;
        private int teamId;

        public int getPosition() {
            return position;
        }

        public void setPosition(int rank) {
            this.position = rank;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String team) {
            this.teamName = team;
        }

        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
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

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
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

        private int playedGames;
        private String crestURI;
        private int points;
        private int goals;
        private int goalsAgainst;
        private int goalDifference;

    }
}
