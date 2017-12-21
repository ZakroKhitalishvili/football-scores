package com.example.zakro.footballscores.Models;

/**
 * Created by zakro on 12/5/17.
 */

public class Team
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getSquadMarketvalue() {
        return squadMarketvalue;
    }

    public void setSquadMarketvalue(int squadMarketvalue) {
        this.squadMarketvalue = squadMarketvalue;
    }

    public String getCrestUlr() {
        return crestUlr;
    }

    public void setCrestUlr(String crestUlr) {
        this.crestUlr = crestUlr;
    }

    private String name;
    private String code;
    private String shortName;
    private int squadMarketvalue;
    private String crestUlr;

    public TeamsOfCompetition.LinksProvider get_links() {
        return _links;
    }

    public void set_links(TeamsOfCompetition.LinksProvider _links) {
        this._links = _links;
    }

    private TeamsOfCompetition.LinksProvider _links;

    public class LinksProvider
    {
        public Href getSelf() {
            return self;
        }

        public void setSelf(Href self) {
            this.self = self;
        }

        public Href getFixtures() {
            return fixtures;
        }

        public void setFixtures(Href fixtures) {
            this.fixtures = fixtures;
        }

        public Href getPlayers() {
            return players;
        }

        public void setPlayers(Href players) {
            this.players = players;
        }

        private Href self;
        private Href fixtures;
        private Href players;
    }
}
