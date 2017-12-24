package com.example.zakro.footballscores.API;

import com.example.zakro.footballscores.Models.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zakro on 12/5/17.
 */

public interface FootballAPIService
{
    @Headers("X-Auth-Token:ef3992fae68842f78752de600842f8b2")

    @GET("competitions")
    Call<Competition[]> getCompetitions();

    @GET("competitions")
    Call<Competition[]> getCompetitions(@Query("season")String season);

    @GET("competitions/{competitionId}")
    Call<Competition> getCompetition(@Path("competitionId")int id);

    @GET("competitions/{competitionId}/teams")
    Call<TeamsOfCompetition[]> getTeamsOfCompetition(@Path("competitionId") int id);

    @GET("competitions/{competitionId}/leagueTable")
    Call<LeagueTable> getLeagueTable(@Path("competitionId") int id);

    @GET("competitions/{competitionId}/fixtures")
    Call<FixturesOfCompetition> getFixturesOfCompetition(@Path("competitionId") int id, @Query("matchday") int matchday);

    @GET("competitions/{competitionId}/fixtures?matchday=1")
    Call<FixturesOfCompetition> getFixturesOfCompetition(@Path("competitionId") int id);

    @GET("fixtures/{fixtureId}")
    Call<Fixture> getFixture(@Path("fixtureId") int id);

    @GET("fixtures/{fixtureId}")
    Call<Fixture> getFixture(@Path("fixtureId") int id, @Query("head2head") int head2headCount);

    @GET("teams/{teamId}")
    Call<Team> getTeam(@Path("teamId") int id);

    @GET("teams/{teamId}/fixtures")
    Call<Fixture[]> getFixturesOfTeam(@Path("teamId") int id);

    @GET("teams/{teamId}/fixtures?timeFrame={timeSide}{count}")
    Call<Fixture[]> getFixturesOfTeam(@Path("teamId") int id,@Path("timeSide") TimeSide timeSide,@Path("count") int count);

    @GET("teams/{teamId}/players")
    Call<PlayersOfTeam[]> getPlayersOfTeam(@Path("teamId") int id);

}
