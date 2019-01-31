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

public class ListActivity extends AppCompatActivity {

    // Déclaration des variables
    private RecyclerView mRecyclerView;
    private List<Rocket> mRockets;
    private List<Ship> mShips;
    private RecyclerViewAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String toShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        mRecyclerView = findViewById(R.id.rv);
        mSwipeRefreshLayout = findViewById(R.id.swipe_container);

        Intent intent = getIntent();
        this.toShow = intent.getStringExtra("toShow");

        switch (toShow) {
            case "rocket":
                setTitle("Rockets");
                break;
            case "ship":
                setTitle("Ships");
                break;
        }

        this.configureSwipeRefreshLayout();
        this.configureRecyclerView();
        this.configureOnClickRecyclerView();
        this.executeRequest();
    }

    // Permet de raffraichir le recyclerView lorsqu'on swipe vers le haut
    private void configureSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                executeRequest();
            }
        });
    }

    // Configure notre RecyclerView
    public void configureRecyclerView() {
        this.mRockets = new ArrayList<>();
        this.mShips = new ArrayList<>();
        this.mAdapter = new RecyclerViewAdapter(Glide.with(this), this.mRockets, null, this.mShips, null, toShow);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false));
    }


    // Execute la requète sur notre API
    public void executeRequest() {
        switch (toShow) {
            case "rocket":
                githubService.getAllRockets().enqueue(new Callback<List<Rocket>>() {
                    @Override
                    public void onResponse(Call<List<Rocket>> call, Response<List<Rocket>> response) {
                        List<Rocket> listRockets = response.body();
                        rocketsDisplay(listRockets);
                    }
                    @Override
                    public void onFailure(Call<List<Rocket>> call, Throwable t) {
                    }
                });
            case "ship":
                githubService.getAllShips().enqueue(new Callback<List<Ship>>() {
                    @Override
                    public void onResponse(Call<List<Ship>> call, Response<List<Ship>> response) {
                        List<Ship> listShips = response.body();
                        shipsDisplay(listShips);
                    }
                    @Override
                    public void onFailure(Call<List<Ship>> call, Throwable t) {
                    }
                });
        }
    }

    // Affiche la liste des rockets dans notre RecyclerView
    public void rocketsDisplay(List<Rocket> listRockets) {
        mSwipeRefreshLayout.setRefreshing(false);
        mRockets.clear();
        mRockets.addAll(listRockets);
        mAdapter.notifyDataSetChanged();
    }

    // Affiche la liste des ships dans notre RecyclerView
    public void shipsDisplay(List<Ship> listShips) {
        mSwipeRefreshLayout.setRefreshing(false);
        mShips.clear();
        mShips.addAll(listShips);
        mAdapter.notifyDataSetChanged();
    }

    // Configure la prise en compte de clique sur un element de notre RecyclerView
    public void configureOnClickRecyclerView() {
        ItemClickSupport.addTo(mRecyclerView, R.layout.list_activity)
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
            case "rocket":
                intent = new Intent(this, RocketActivity.class);
                intent.putExtra("data", mRockets.get(position));
                startActivity(intent);
                break;
            case "ship":
                intent = new Intent(this, ShipActivity.class);
                intent.putExtra("data", mShips.get(position));
                startActivity(intent);
                break;
        }
    }
}
