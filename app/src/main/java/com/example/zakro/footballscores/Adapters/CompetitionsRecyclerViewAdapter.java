package com.example.zakro.footballscores.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zakro.footballscores.Models.Competition;
import com.example.zakro.footballscores.R;

/**
 * Created by zakro on 12/15/17.
 */

public class CompetitionsRecyclerViewAdapter extends RecyclerView.Adapter<CompetitionsRecyclerViewAdapter.ViewHolder>
{
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.competition_item_layout,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.competitionName.setText(competitions[position].getLeague());
        holder.competitionCaption.setText(competitions[position].getCaption());
        holder.competitionYear.setText(competitions[position].getYear());
        holder.competitionLastUpdate.setText(DateToSimpleString.convert(competitions[position].getLastUpdated()));
    }

    @Override
    public int getItemCount() {
        return competitions.length;
    }
    private Competition[] competitions=new Competition[0];

    public void setCompetitions(Competition[] competitions)
    {
        this.competitions=competitions;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView competitionName;
        public TextView competitionCaption;
        public TextView competitionYear;
        public TextView competitionLastUpdate;

        public ViewHolder(View itemView)
        {
            super(itemView);
            competitionName=itemView.findViewById(R.id.competitionName);
            competitionCaption=itemView.findViewById(R.id.competitionCaption);
            competitionYear=itemView.findViewById(R.id.competitionYear);
            competitionLastUpdate=itemView.findViewById(R.id.competitionLastUpdate);
        }
    }
}
