package com.example.zakro.footballscores.API;

/**
 * Created by zakro on 12/15/17.
 */

public enum TimeSide
{
    Next("n"),
    Past("p");

    private final String sym;


    TimeSide(final String sym)
    {
        this.sym=sym;
    }

    @Override
    public String toString()
    {
        return sym;
    }
}
