package com.alexandreexample.spacexapp.Controls;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexandreexample.spacexapp.Models.Capsule;
import com.alexandreexample.spacexapp.Models.Launch;
import com.alexandreexample.spacexapp.Models.Rocket;
import com.alexandreexample.spacexapp.Models.Ship;
import com.alexandreexample.spacexapp.R;
import com.bumptech.glide.RequestManager;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private RequestManager glide;
    private List<Rocket> rockets;
    private List<Launch> launches;
    private List<Ship> ships;
    private List<Capsule> capsules;
    private String toShow;

    // CONSTRUCTOR
    public RecyclerViewAdapter(RequestManager glide, List<Rocket> rockets, List<Launch> launches, List<Ship> ships, List<Capsule> capsules, String toShow) {
        this.rockets = rockets;
        this.launches = launches;
        this.ships = ships;
        this.capsules = capsules;
        this.glide = glide;
        this.toShow = toShow;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        switch (toShow) {
            case "rocket":
                holder.RocketsDisplay(rockets.get(position), this.glide);
                break;
            case "launch":
                holder.LaunchesDisplay(launches.get(position), this.glide);
                break;
            case "ship":
                holder.ShipsDisplay(ships.get(position), this.glide);
                break;
            case "capsule":
                holder.CapsulesDisplay(capsules.get(position), this.glide);
                break;
        }

    }

    @Override
    public int getItemCount() {
        int count = 0;
        switch (toShow) {
            case "rocket":
                count = rockets.size();
                break;
            case "launch":
                count = launches.size();
                break;
            case "ship":
                count = ships.size();
                break;
            case "capsule":
                count = capsules.size();
                break;
        }
        return count;
    }


}
