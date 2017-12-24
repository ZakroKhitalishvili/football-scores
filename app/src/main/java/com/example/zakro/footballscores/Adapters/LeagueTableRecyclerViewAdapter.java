package com.example.zakro.footballscores.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caverock.androidsvg.SVGImageView;
import com.example.zakro.footballscores.Models.LeagueTable;
import com.example.zakro.footballscores.R;
import com.example.zakro.footballscores.Svg.SvgView;


import com.squareup.picasso.Picasso;

/**
 * Created by zakro on 12/19/17.
 */

public class LeagueTableRecyclerViewAdapter extends RecyclerView.Adapter<LeagueTableRecyclerViewAdapter.ViewHolder>
{
    private LeagueTable.StandingTeam[] standingTeams;

    public void setStandingTeams(LeagueTable.StandingTeam[] standingTeams)
    {
        this.standingTeams=standingTeams;
    }



    public void Update()
    {
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.league_standing_team_layout,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.rank.setText(String.valueOf(standingTeams[position].getPosition()));
        if(standingTeams[position].getCrestURI()!=null) {
            if (!standingTeams[position].getCrestURI().isEmpty()) {

                if(standingTeams[position].getCrestURI().endsWith(".svg"))
                {
                    //SvgView.initSvgView(holder.viewItem.getContext(),holder.crest,standingTeams[position].getCrestURI());
                    //Svger.with(holder.viewItem.getContext()).load(standingTeams[position].getCrestURI()).into(holder.crest);
                }
                else {
                    Glide.with(holder.viewItem.getContext()).load(standingTeams[position].getCrestURI()).into(holder.crest);
                }

            }
        }
        holder.team.setText(standingTeams[position].getTeamName());
        holder.games.setText(String.valueOf(standingTeams[position].getPlayedGames()));
        holder.goals.setText(String.valueOf(standingTeams[position].getGoals()));
        holder.goalsAgainst.setText(String.valueOf(standingTeams[position].getGoalsAgainst()));
        holder.goalsDifference.setText(String.valueOf(standingTeams[position].getGoalDifference()));
        holder.points.setText(String.valueOf(standingTeams[position].getPoints()));
    }

    @Override
    public int getItemCount() {
        return standingTeams.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView rank;
        public ImageView crest;
        public TextView team;
        public TextView games;
        public TextView goals;
        public TextView goalsAgainst;
        public TextView goalsDifference;
        public TextView points;

        private View viewItem;

        public ViewHolder(View itemView) {
            super(itemView);

            this.viewItem=itemView;
            rank=itemView.findViewById(R.id.standingTeamRank);
            crest=itemView.findViewById(R.id.standingTeamCrest);
            team=itemView.findViewById(R.id.standingTeamName);
            games=itemView.findViewById(R.id.standingTeamPlayedGames);
            goals=itemView.findViewById(R.id.standingTeamGoals);
            goalsAgainst=itemView.findViewById(R.id.standingTeamGoalsAgainst);
            goalsDifference=itemView.findViewById(R.id.standingTeamGoalsDifference);
            points=itemView.findViewById(R.id.standingTeamPoints);
        }


    }
}
