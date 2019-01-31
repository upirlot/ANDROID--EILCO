package com.alexandreexample.spacexapp.Views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexandreexample.spacexapp.Models.Ship;
import com.alexandreexample.spacexapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ShipActivity extends AppCompatActivity implements View.OnClickListener {

    Ship ship;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ship_activity);

        TextView tvPort = findViewById(R.id.port);
        TextView tvStatus = findViewById(R.id.status);
        Button btnDetails = findViewById(R.id.details);
        mImageView = findViewById(R.id.imageView);

        btnDetails.setOnClickListener(this);

        Intent intent = getIntent();
        ship = (Ship) intent.getSerializableExtra("data");

        setTitle(ship.getShipName());

        setPicture();

        if(ship.getHomePort() != null){
            tvPort.setText(String.format("Port : %s", ship.getHomePort()));
        }
        if(ship.getStatus() != null) {
            tvStatus.setText(String.format("Status : %s", ship.getStatus()));
        }
        if(ship.getUrl() == null) {
            btnDetails.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.details:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(ship.getUrl()));
                startActivity(intent);
                break;
        }
    }

    public void setPicture() {
        Glide.with(this).load(ship.getImage()).into(mImageView);
    }
}
