package com.example.zakro.footballscores.API;

/**
 * Created by zakro on 12/15/17.
 */

public enum Venue
{
    Home("home"),
    Away("away");


    private final String expr;

    private Venue(final String expr)
    {
        this.expr=expr;
    }
    @Override
    public String toString()
    {
        return expr;
    }
}
