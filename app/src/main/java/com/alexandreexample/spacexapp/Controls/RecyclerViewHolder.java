package com.alexandreexample.spacexapp.Controls;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexandreexample.spacexapp.Models.Capsule;
import com.alexandreexample.spacexapp.Models.Launch;
import com.alexandreexample.spacexapp.Models.Rocket;
import com.alexandreexample.spacexapp.Models.Ship;
import com.alexandreexample.spacexapp.R;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView myRocketName;
    private ImageView myPicture;

    RecyclerViewHolder(View itemView) {
        super(itemView);
        myRocketName = itemView.findViewById(R.id.rocket_name);
        myPicture = itemView.findViewById(R.id.picture);
    }

    void RocketsDisplay(Rocket rocket, RequestManager glide) {
        this.myRocketName.setText(rocket.getRocketName());
        if(rocket.getFlickrImages().get(0) != null){
            glide.load(rocket.getFlickrImages().get(0)).apply(RequestOptions.circleCropTransform()).into(myPicture);
        } else {
            glide.load(R.drawable.rocket).apply(RequestOptions.circleCropTransform()).into(myPicture);
        }
    }

    void LaunchesDisplay(Launch launches, RequestManager glide) {
        this.myRocketName.setText(launches.getMissionName());
        if(launches.getLinks().getMissionPatchSmall() != null){
            glide.load(launches.getLinks().getMissionPatchSmall()).into(myPicture);
        } else {
            glide.load(R.drawable.rocket).apply(RequestOptions.circleCropTransform()).into(myPicture);
        }
    }

    void ShipsDisplay(Ship ships, RequestManager glide) {
        this.myRocketName.setText(ships.getShipName());
        if(ships.getImage() != null){
            glide.load(ships.getImage()).apply(RequestOptions.circleCropTransform()).into(myPicture);
        } else {
            glide.load(R.drawable.ship).apply(RequestOptions.circleCropTransform()).into(myPicture);
        }
    }

    void CapsulesDisplay(Capsule capsules, RequestManager glide) {
        this.myRocketName.setText(capsules.getCapsuleSerial());
        glide.load(R.drawable.rocket).apply(RequestOptions.circleCropTransform()).into(myPicture);
        /*if(capsules.getLinks().getMissionPatchSmall() != null){
            glide.load(capsules.getLinks().getMissionPatchSmall()).apply(RequestOptions.circleCropTransform()).into(myPicture);
        } else {
            glide.load(R.drawable.rocket).apply(RequestOptions.circleCropTransform()).into(myPicture);
        }*/
    }
}
