package com.example.zakro.footballscores.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zakro.footballscores.Models.LeagueTable;
import com.example.zakro.footballscores.R;
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
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.league_standing_team_layout,parent);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.rank.setText(standingTeams[position].getRank());
        Picasso.with(holder.viewItem.getContext()).load(standingTeams[position].getCrestURI()).into(holder.crest);
        holder.team.setText(standingTeams[position].getTeam());
        holder.games.setText(standingTeams[position].getPlayedGames());
        holder.goals.setText(standingTeams[position].getGoals());
        holder.goalsAgainst.setText(standingTeams[position].getGoalsAgainst());
        holder.goalsDifference.setText(standingTeams[position].getGoalDifference());
        holder.points.setText(standingTeams[position].getPoints());
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
