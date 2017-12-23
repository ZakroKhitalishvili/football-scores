package com.example.zakro.footballscores.Models;

/**
 * Created by zakro on 12/5/17.
 */

public class FixturesOfCompetition
{
    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Fixture[] getFixtures() {
        return fixtures;
    }

    public void setFixtures(Fixture[] fixtures) {
        this.fixtures = fixtures;
    }

    public LinksProvider get_links() {
        return _links;
    }

    public void set_links(LinksProvider _links) {
        this._links = _links;
    }

    private String season;
    private int count;
    private Fixture[] fixtures;
    private FixturesOfCompetition.LinksProvider _links;

    public class LinksProvider
    {
        public Href getSelf() {
            return self;
        }

        public void setSelf(Href self) {
            this.self = self;
        }

        public Href getTeam() {
            return team;
        }

        public void setTeam(Href team) {
            this.team = team;
        }

        private Href self;
        private Href team;
    }

}
