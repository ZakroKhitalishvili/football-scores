package com.example.zakro.footballscores.Models;

import java.util.List;

/**
 * Created by zakro on 12/5/17.
 */

public class TeamsOfCompetition
{
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public LinksProvider get_links() {
        return _links;
    }

    public void set_links(LinksProvider _links) {
        this._links = _links;
    }

    private Team[] teams;
    private LinksProvider _links;


    public class LinksProvider
    {
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

        private Href self;
        private Href competition;
    }

}
