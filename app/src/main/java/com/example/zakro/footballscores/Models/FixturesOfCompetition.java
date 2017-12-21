package com.example.zakro.footballscores.Models;

/**
 * Created by zakro on 12/5/17.
 */

public class FixturesOfCompetition
{
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
