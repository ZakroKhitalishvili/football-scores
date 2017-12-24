package com.example.zakro.footballscores.Adapters;

import java.util.Date;

/**
 * Created by zakro on 12/24/17.
 */

public class DateToSimpleString {


    public static String convert(Date date)
    {
        return String.format("%1$td-%1$tm %1$tH:%1$tM",date);
    }
}
