package com.example.zakro.footballscores.Models;

/**
 * Created by zakro on 12/5/17.
 */

public class PlayersOfTeam
{
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public LinksProvider get_links() {
        return _links;
    }

    public void set_links(LinksProvider _links) {
        this._links = _links;
    }

    private Player[] players;
    private LinksProvider _links;

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
