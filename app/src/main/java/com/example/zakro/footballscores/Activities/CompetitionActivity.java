package com.example.zakro.footballscores.Activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zakro.footballscores.API.FootballAPIService;
import com.example.zakro.footballscores.API.FootballService;
import com.example.zakro.footballscores.Adapters.LeagueFixturesRecyclerViewAdapter;
import com.example.zakro.footballscores.Adapters.LeagueTableRecyclerViewAdapter;
import com.example.zakro.footballscores.Models.Fixture;
import com.example.zakro.footballscores.Models.FixturesOfCompetition;
import com.example.zakro.footballscores.Models.LeagueTable;
import com.example.zakro.footballscores.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompetitionActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    protected FootballAPIService mApiService;
    private int mCompetitionId;
    private AlertDialog matchdayDialog;
    private TextView mTableTab;
    private TextView mFixturesTab;
    EditText editText;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTableTab = findViewById(R.id.leagueTableTabName);
        mFixturesTab = findViewById(R.id.fixturesTabName);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mApiService= FootballService.getInstance();
        mCompetitionId=getIntent().getIntExtra("competitionID",-1);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),mCompetitionId);
        editText=new EditText(this);
         // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {}
            @Override
            public void onPageSelected(int position) {
                if(position==0)
                {
                    mTableTab.setBackgroundResource(R.color.colorAppPrimaryShade1);
                    mFixturesTab.setBackgroundResource(R.color.colorAppPrimaryShade4);
                }
                if(position==1) {
                    mFixturesTab.setBackgroundResource(R.color.colorAppPrimaryShade1);
                    mTableTab.setBackgroundResource(R.color.colorAppPrimaryShade4);

                }
            }
            @Override
            public void onPageScrollStateChanged(int state)
            {}
        });

        initMatchdayDialog();

    }

    private void initMatchdayDialog()
    {
        matchdayDialog=new AlertDialog.Builder(this)
                .setTitle("Select Match day")
                .setView(editText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        FixturesFragment frag= (FixturesFragment)getSupportFragmentManager()
                                .findFragmentByTag("android:switcher:"+R.id.container+":1");

                        String input=editText.getText().toString();
                        if(input!=null)
                        {

                            input=input.trim();

                            if(!input.isEmpty() && input.matches("^[0-9]*$"))
                            {
                                int inputNum=Integer.parseInt(input);
                                if(inputNum>(LeagueTableFragment.teamsCount-1)*2 || inputNum==0)
                                {
                                    Toast.makeText(getApplicationContext(),"Invalid number: out of a range",Toast.LENGTH_LONG).show();
                                    editText.setText("");
                                }
                                else {
                                    frag.loadFixtures(inputNum);
                                }
                            }
                            else
                            {
                                Toast.makeText(getBaseContext(),"Invalid Input",Toast.LENGTH_LONG).show();
                                editText.setText("");
                            }
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((AlertDialog)dialog).cancel();
                    }
                })
                .create();
    }
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_competition, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_matchday)
        {
            matchdayDialog.show();

        }

        return super.onOptionsItemSelected(item);
    }


    public static class LeagueTableFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_COMPETITION_ID="competition_id";
        private LeagueTable leagueTable;
        private RecyclerView recyclerView;
        private LeagueTableRecyclerViewAdapter tableRecyclerAdapter;
        static public int teamsCount;

        public LeagueTableFragment() {

        }

        public static LeagueTableFragment newInstance(int competitionId) {
            LeagueTableFragment fragment = new LeagueTableFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, 0);
            args.putInt(ARG_COMPETITION_ID,competitionId);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_competition, container, false);
            recyclerView = (RecyclerView)rootView.findViewById(R.id.leagueTableRecycler);

            init();
            loadLeagueTable();

            return rootView;
        }

        private void init()
        {

            tableRecyclerAdapter=new LeagueTableRecyclerViewAdapter();
            tableRecyclerAdapter.setStandingTeams(new LeagueTable.StandingTeam[0]);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(tableRecyclerAdapter);
        }

        @SuppressLint("RestrictedApi")
        private void loadLeagueTable()
        {
            int competitionId= getArguments().getInt(ARG_COMPETITION_ID);
            final Call<LeagueTable> leagueTableCall=  FootballService.getInstance().getLeagueTable(competitionId);
            leagueTableCall.request().headers().newBuilder().add("X-Auth-Token","ef3992fae68842f78752de600842f8b2");
            leagueTableCall.enqueue(new Callback<LeagueTable>() {
                @Override
                public void onResponse(Call<LeagueTable> call, Response<LeagueTable> response) {
                    if(response.isSuccessful())
                    {
                        leagueTable=response.body();
                        teamsCount=leagueTable.getStanding().length;
                        tableRecyclerAdapter.setStandingTeams(leagueTable.getStanding());
                        recyclerView.setAdapter(tableRecyclerAdapter);
                        Log.d("LoadLeagueTable","Successfull");
                        // leaguetable shi daamate Statndingteam masivi
                    }
                    else
                    {
                        Log.d("LoadLeagueTable","Unsuccessfull");
                    }
                }

                @Override
                public void onFailure(Call<LeagueTable> call, Throwable t) {
                    Log.d("LoadLeagueTable","Failure");
                }
            });


        }
    }

    public static class FixturesFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_COMPETITION_ID="competition_id";
        private FixturesOfCompetition fixturesOfCompetition;
        private RecyclerView recyclerView;
        private LeagueFixturesRecyclerViewAdapter fixturesRecyclerViewAdapter;

        public FixturesFragment() {
        }


        public static FixturesFragment newInstance(int competitionId) {
            FixturesFragment fragment = new FixturesFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, 1);
            args.putInt(ARG_COMPETITION_ID,competitionId);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_competition_fixtures_layout, container, false);
            recyclerView=rootView.findViewById(R.id.competitionFixturesRecycler);

            init();
            loadFixtures(1);

            return rootView;
        }

        private void init()
        {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
            fixturesRecyclerViewAdapter=new LeagueFixturesRecyclerViewAdapter();
            fixturesRecyclerViewAdapter.setFixtures(new Fixture[0]);
            recyclerView.setAdapter(fixturesRecyclerViewAdapter);
            recyclerView.setHasFixedSize(true);
        }

        private void loadFixtures(int matchDay)
        {
            int competitionId=getArguments().getInt(ARG_COMPETITION_ID);
            final Call<FixturesOfCompetition> fixturesCall=FootballService.getInstance().getFixturesOfCompetition(competitionId,matchDay);
            fixturesCall.enqueue(new Callback<FixturesOfCompetition>() {
                @Override
                public void onResponse(Call<FixturesOfCompetition> call, Response<FixturesOfCompetition> response) {
                    if(response.isSuccessful())
                    {
                        if(response.body()!=null) {
                            if (response.body().getFixtures() != null) {
                                fixturesRecyclerViewAdapter.setFixtures(response.body().getFixtures());

                            } else {
                                fixturesRecyclerViewAdapter.setFixtures(new Fixture[0]);
                            }
                        }
                        else {
                            fixturesRecyclerViewAdapter.setFixtures(new Fixture[0]);
                        }
                        recyclerView.setAdapter(fixturesRecyclerViewAdapter);
                    }
                    else
                    {
                        Log.d("FixturesCall","Unsuccessfull");
                    }
                }

                @Override
                public void onFailure(Call<FixturesOfCompetition> call, Throwable t) {
                    Log.d("FixturesCall","Failure");

                }
            });
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private FragmentManager fragmentManager;
        private int competitionId;
        public SectionsPagerAdapter(FragmentManager fm,int competitionId) {
            super(fm);
            fragmentManager=fm;
            this.competitionId=competitionId;
        }

        @Override
        public Fragment getItem(int position) {

            if(position==0) {
                return LeagueTableFragment.newInstance(competitionId);
            }
            if(position==1) {
                return FixturesFragment.newInstance(competitionId);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }
}
