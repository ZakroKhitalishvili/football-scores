package com.example.zakro.footballscores.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("X-Auth-Token", "ef3992fae68842f78752de600842f8b2").build();
                return chain.proceed(newRequest);
            }
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.football-data.org/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        footballAPIService = retrofit.create(FootballAPIService.class);
    }

}
