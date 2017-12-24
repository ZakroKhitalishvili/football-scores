package com.example.zakro.footballscores.Activities;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zakro.footballscores.API.FootballAPIService;
import com.example.zakro.footballscores.API.FootballService;
import com.example.zakro.footballscores.Adapters.CompetitionsRecyclerViewAdapter;
import com.example.zakro.footballscores.EventListeners.RecyclerItemClickListener;
import com.example.zakro.footballscores.EventListeners.RecyclerTouchListener;
import com.example.zakro.footballscores.Models.Competition;
import com.example.zakro.footballscores.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FootballAPIService mApiService;
    private Competition[] mCompetitions;
    private RecyclerView mCompetitionsRecycler;
    private CompetitionsRecyclerViewAdapter mCompetitionsRecyclerAdapter;
    private TextView mNoLoadMessage;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loadCompetitions();
    }
    //initializations
    private void init()
    {
        mCompetitions = new Competition[0];
        mApiService = FootballService.getInstance();
        mCompetitionsRecycler = (RecyclerView)findViewById(R.id.competitionRecycler);
        mCompetitionsRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mCompetitionsRecyclerAdapter =new CompetitionsRecyclerViewAdapter();
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        mNoLoadMessage = (TextView)findViewById(R.id.noLoadMessage);

        //Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
             @Override
             public void onRefresh() {
                 loadCompetitions();
             }
         });
        mCompetitionsRecycler.addOnItemTouchListener(
                new RecyclerTouchListener(this,
                        mCompetitionsRecycler,
                        new RecyclerItemClickListener() {
                            @Override
                            public void onClick(View v, int position) {

                                Intent intent=new Intent(MainActivity.this,CompetitionActivity.class);
                                intent.putExtra("competitionID",mCompetitions[position].getId());
                                startActivityForResult(intent,0);
                            }
                        }));
    }

    private void loadCompetitions()
    {
        Call < Competition[]> userCall = mApiService.getCompetitions();

        userCall.enqueue(new Callback<Competition[]>() {
            @Override
            public void onResponse(Call<Competition[]> call, Response<Competition[]> response) {
                if(response.isSuccessful())
                {
                    mCompetitions =response.body();
                    //updates recycler's adapter
                    mCompetitionsRecyclerAdapter.setCompetitions(mCompetitions);
                    mCompetitionsRecycler.setAdapter(mCompetitionsRecyclerAdapter);
                    //hides error message view and shows recyclerView
                    mNoLoadMessage.setVisibility(View.INVISIBLE);
                    mCompetitionsRecycler.setVisibility(View.VISIBLE);
                }
                else
                {
                    //after unsuccessfull call shows corresponding message and hides recyclerview
                    mCompetitionsRecyclerAdapter.setCompetitions(new Competition[0]);
                    mNoLoadMessage.setVisibility(View.VISIBLE);
                    mCompetitionsRecycler.setVisibility(View.GONE);
                    mNoLoadMessage.setText("No competition loaded");
                }
                mSwipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<Competition[]> call, Throwable t) {
                //after failure hides recyclerView and shows error message
                Log.d("CompetitionError","Failed loading competitions");
                mNoLoadMessage.setVisibility(View.VISIBLE);
                mCompetitionsRecycler.setVisibility(View.GONE);
                mNoLoadMessage.setText("Error loading competitions");
                mSwipeRefreshLayout.setRefreshing(false);
                mCompetitionsRecyclerAdapter.setCompetitions(new Competition[0]);
            }
        });
        mCompetitionsRecycler.setAdapter(mCompetitionsRecyclerAdapter);
    }

}
