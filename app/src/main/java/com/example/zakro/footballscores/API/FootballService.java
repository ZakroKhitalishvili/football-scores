package com.example.zakro.footballscores.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zakro on 12/14/17.
 */

public class FootballService {
    private static  final FootballService footballService=new FootballService();

    private FootballAPIService footballAPIService;

    public static FootballAPIService getInstance() {
        return footballService.footballAPIService;
    }


    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.football-data.org/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        footballAPIService = retrofit.create(FootballAPIService.class);
    }

}
