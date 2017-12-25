package com.example.zakro.footballscores.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zakro.footballscores.Models.Fixture;
import com.example.zakro.footballscores.R;

import java.util.zip.Inflater;

/**
 * Created by zakro on 12/24/17.
 */

public class LeagueFixturesRecyclerViewAdapter extends RecyclerView.Adapter<LeagueFixturesRecyclerViewAdapter.ViewHolder>
{

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fixtures_item_layout,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    private Fixture[] fixtures;

    public void setFixtures(Fixture[] fixtures)
    {
        this.fixtures=fixtures;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.date.setText(DateToSimpleString.convert(fixtures[position].getDate()));
        holder.homeTeam.setText(fixtures[position].getHomeTeamName());
        holder.awayTeam.setText(fixtures[position].getAwayTeamName());
        if(fixtures[position].getResult()!=null) {
            if(fixtures[position].getStatus().equals("FINISHED")) {
                holder.homeTeamGoals.setText(String.valueOf(fixtures[position].getResult().getGoalsHomeTeam()));
                holder.awayTeamGoals.setText(String.valueOf(fixtures[position].getResult().getGoalsAwayTeam()));
            }
            else
            {
                holder.homeTeamGoals.setText("-");
                holder.awayTeamGoals.setText("-");
            }
        }
    }

    @Override
    public int getItemCount() {
        return fixtures.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView date;
        public TextView homeTeam;
        public TextView awayTeam;
        public TextView homeTeamGoals;
        public TextView awayTeamGoals;
        public ViewHolder(View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.competitionFixtureDate);
            homeTeam=itemView.findViewById(R.id.competitionFixtureHomeTeam);
            awayTeam=itemView.findViewById(R.id.competitionFixtureAwayTeam);
            homeTeamGoals=itemView.findViewById(R.id.competitionFixtureHomeTeamGoals);
            awayTeamGoals=itemView.findViewById(R.id.competitionFixtureAwayTeamGoals);
        }
    }

}
