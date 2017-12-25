package com.example.zakro.footballscores.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.transition.Visibility;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caverock.androidsvg.SVGImageView;
import com.example.zakro.footballscores.Models.LeagueTable;
import com.example.zakro.footballscores.R;
import com.example.zakro.footballscores.Svg.SvgView;


import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParser;

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
    private Context context;


    public void Update()
    {
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.league_standing_team_layout,parent,false);
        ViewHolder vh=new ViewHolder(view);
        this.context=parent.getContext();
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
                    if(holder.svgCrest!=null) {

                        SvgView.initSvgView(this.context, holder.svgCrest, standingTeams[position].getCrestURI());
                        holder.svgCrest.setVisibility(View.VISIBLE);
                        if(holder.crest!=null) {
                            holder.crest.setVisibility(View.GONE);
                        }
                        holder.crest = null;
                        //Svger.with(holder.viewItem.getContext()).load(standingTeams[position].getCrestURI()).into(holder.crest);
                    }
                    else
                    {
                        holder.svgCrest=new SVGImageView(this.context);
                        holder.svgCrest.setLayoutParams(holder.pars);
                        holder.group.addView(holder.svgCrest,1);
                        SvgView.initSvgView(this.context, holder.svgCrest, standingTeams[position].getCrestURI());
                        if(holder.crest!=null) {
                            holder.crest.setVisibility(View.GONE);
                        }
                        holder.crest = null;
                    }
                }
                else {
                    if(holder.crest!=null) {
                        holder.crest.setVisibility(View.VISIBLE);
                        Glide.with(this.context).load(standingTeams[position].getCrestURI()).into(holder.crest);
                        holder.svgCrest = null;
                    }
                    else
                    {
                        holder.crest=new ImageView(this.context);
                        holder.crest.setLayoutParams(holder.pars);
                        holder.group.addView(holder.crest,1);
                        Glide.with(this.context).load(standingTeams[position].getCrestURI()).into(holder.crest);
                        if(holder.svgCrest!=null) {
                            holder.svgCrest.setVisibility(View.GONE);
                        }
                        holder.svgCrest = null;
                    }
                }

            }
        }
        else
        {
            if(holder.crest!=null) {
                holder.crest.setVisibility(View.VISIBLE);
                holder.svgCrest=null;
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
        public SVGImageView svgCrest;
        public TextView team;
        public TextView games;
        public TextView goals;
        public TextView goalsAgainst;
        public TextView goalsDifference;
        public TextView points;
        public ViewGroup group;
        public  LinearLayout.LayoutParams pars;

        public ViewHolder(View itemView) {
            super(itemView);


            rank=itemView.findViewById(R.id.standingTeamRank);
            //crest=itemView.findViewById(R.id.standingTeamCrest);
            team=itemView.findViewById(R.id.standingTeamName);
            games=itemView.findViewById(R.id.standingTeamPlayedGames);
            goals=itemView.findViewById(R.id.standingTeamGoals);
            goalsAgainst=itemView.findViewById(R.id.standingTeamGoalsAgainst);
            goalsDifference=itemView.findViewById(R.id.standingTeamGoalsDifference);
            points=itemView.findViewById(R.id.standingTeamPoints);
            group= (ViewGroup)itemView.findViewById(R.id.standingTeam);

            pars=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            pars.weight=1;
            pars.width=0;
             svgCrest=new SVGImageView(itemView.getContext());
            svgCrest.setLayoutParams(pars);
            svgCrest.setVisibility(View.GONE);
            LayoutInflater infl= LayoutInflater.from(itemView.getContext());
            group.addView(svgCrest,1);

            crest=new ImageView(itemView.getContext());
            crest.setLayoutParams(pars);
            crest.setVisibility(View.GONE);
            group.addView(crest,1);




        }


    }
}

