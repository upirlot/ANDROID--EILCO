package com.alexandreexample.spacexapp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.alexandreexample.spacexapp.Controls.ItemClickSupport;
import com.alexandreexample.spacexapp.Models.Capsule;
import com.alexandreexample.spacexapp.Models.Launch;
import com.alexandreexample.spacexapp.Models.Rocket;
import com.alexandreexample.spacexapp.Models.Ship;
import com.alexandreexample.spacexapp.R;
import com.alexandreexample.spacexapp.Controls.RecyclerViewAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.alexandreexample.spacexapp.Controls.GithubService.githubService;

public class ChoicesListActivity extends AppCompatActivity implements View.OnClickListener {

    // Déclaration des variables
    private RecyclerView mRecyclerView;
    private List<Launch> mLaunches;
    private List<Capsule> mCapsules;
    private RecyclerViewAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String toShow, onView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choices_list_activity);

        mRecyclerView = findViewById(R.id.rv);
        mSwipeRefreshLayout = findViewById(R.id.swipe_container);
        Button all = findViewById(R.id.all);
        Button past = findViewById(R.id.past);
        Button upcoming = findViewById(R.id.upcoming);
        onView = "all";

        Intent intent = getIntent();
        this.toShow = intent.getStringExtra("toShow");

        switch (toShow) {
            case "rocket":
                setTitle("Rockets");
                break;
            case "launch":
                setTitle("Launches");
                break;
            case "capsule":
                setTitle("Capsules");
                break;
        }

        all.setOnClickListener(this);
        past.setOnClickListener(this);
        upcoming.setOnClickListener(this);

        this.configureSwipeRefreshLayout();
        this.configureRecyclerView();
        this.configureOnClickRecyclerView();
        this.executeAllRequest();
    }

    // Permet de raffraichir le recyclerView lorsqu'on swipe vers le haut
    private void configureSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                switch (onView){
                    case "all":
                        executeAllRequest();
                        break;
                    case "past":
                        executePastRequest();
                        break;
                    case "upcoming":
                        executeUpcomingRequest();
                        break;
                }
            }
        });
    }

    // Configure notre RecyclerView
    public void configureRecyclerView() {
        this.mLaunches = new ArrayList<>();
        this.mCapsules = new ArrayList<>();
        this.mAdapter = new RecyclerViewAdapter(Glide.with(this), null, this.mLaunches, null, this.mCapsules, toShow);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false));
    }


    // Execute la requète sur notre API
    public void executeAllRequest() {
        switch (toShow) {
            case "launch":
                githubService.getAllLaunches().enqueue(new Callback<List<Launch>>() {
                    @Override
                    public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                        List<Launch> listLaunches = response.body();
                        launchesDisplay(listLaunches);
                    }
                    @Override
                    public void onFailure(Call<List<Launch>> call, Throwable t) {
                    }
                });
            case "capsule":
                githubService.getAllCapsules().enqueue(new Callback<List<Capsule>>() {
                    @Override
                    public void onResponse(Call<List<Capsule>> call, Response<List<Capsule>> response) {
                        List<Capsule> listCapsules = response.body();
                        capsulesDisplay(listCapsules);
                    }
                    @Override
                    public void onFailure(Call<List<Capsule>> call, Throwable t) {
                    }
                });
        }
    }

    public void executePastRequest() {
        switch (toShow) {
            case "launch":
                githubService.getPastLaunches().enqueue(new Callback<List<Launch>>() {
                    @Override
                    public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                        List<Launch> listLaunches = response.body();
                        launchesDisplay(listLaunches);
                    }
                    @Override
                    public void onFailure(Call<List<Launch>> call, Throwable t) {
                    }
                });
            case "capsule":
                githubService.getPastCapsules().enqueue(new Callback<List<Capsule>>() {
                    @Override
                    public void onResponse(Call<List<Capsule>> call, Response<List<Capsule>> response) {
                        List<Capsule> listCapsules = response.body();
                        capsulesDisplay(listCapsules);
                    }
                    @Override
                    public void onFailure(Call<List<Capsule>> call, Throwable t) {
                    }
                });
        }
    }

    public void executeUpcomingRequest() {
        switch (toShow) {
            case "launch":
                githubService.getUpcomingLaunches().enqueue(new Callback<List<Launch>>() {
                    @Override
                    public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                        List<Launch> listLaunches = response.body();
                        launchesDisplay(listLaunches);
                    }
                    @Override
                    public void onFailure(Call<List<Launch>> call, Throwable t) {
                    }
                });
            case "capsule":
                githubService.getUpcomingCapsules().enqueue(new Callback<List<Capsule>>() {
                    @Override
                    public void onResponse(Call<List<Capsule>> call, Response<List<Capsule>> response) {
                        List<Capsule> listCapsules = response.body();
                        capsulesDisplay(listCapsules);
                    }
                    @Override
                    public void onFailure(Call<List<Capsule>> call, Throwable t) {
                    }
                });
        }
    }

    // Affiche la liste des launches dans notre RecyclerView
    public void launchesDisplay(List<Launch> listLaunches) {
        mSwipeRefreshLayout.setRefreshing(false);
        mLaunches.clear();
        mLaunches.addAll(listLaunches);
        mAdapter.notifyDataSetChanged();
    }

    // Affiche la liste des ships dans notre RecyclerView
    public void capsulesDisplay(List<Capsule> listCapsules) {
        mSwipeRefreshLayout.setRefreshing(false);
        mCapsules.clear();
        mCapsules.addAll(listCapsules);
        mAdapter.notifyDataSetChanged();
    }

    // Configure la prise en compte de clique sur un element de notre RecyclerView
    public void configureOnClickRecyclerView() {
        ItemClickSupport.addTo(mRecyclerView, R.layout.choices_list_activity)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        redirection(position);
                    }
                });
    }

    // Redirige vers la page Details permettant d'avoir des information sur l'élément choisi
    public void redirection(int position) {
        Intent intent;
        switch (toShow) {
            case "launch":
                intent = new Intent(this, LaunchActivity.class);
                intent.putExtra("data", mLaunches.get(position));
                startActivity(intent);
                break;
            case "capsule":
                intent = new Intent(this, CapsuleActivity.class);
                intent.putExtra("data", mCapsules.get(position));
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.all:
                onView = "all";
                executeAllRequest();
                break;
            case R.id.past:
                onView = "past";
                executePastRequest();
                break;
            case R.id.upcoming:
                onView = "upcoming";
                executeUpcomingRequest();
                break;
        }
    }
}
