package com.alexandreexample.spacexapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.alexandreexample.spacexapp.Models.Launch;
import com.alexandreexample.spacexapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.alexandreexample.spacexapp.Controls.GithubService.githubService;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Launch launch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Button btnRockets = findViewById(R.id.btnRockets);
        Button btnLaunches = findViewById(R.id.btnLaunches);
        Button btnNextLaunch = findViewById(R.id.btnNextLaunch);
        Button btnLatestLaunch = findViewById(R.id.btnLatestLaunch);
        Button btnShips = findViewById(R.id.btnShips);
        Button btnCapsule = findViewById(R.id.btnCapsule);

        btnRockets.setOnClickListener(this);
        btnLaunches.setOnClickListener(this);
        btnNextLaunch.setOnClickListener(this);
        btnLatestLaunch.setOnClickListener(this);
        btnShips.setOnClickListener(this);
        btnCapsule.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnRockets:
                intent = new Intent(this, ListActivity.class);
                intent.putExtra("toShow", "rocket");
                startActivity(intent);
                break;
            case R.id.btnLaunches:
                intent = new Intent(this, ChoicesListActivity.class);
                intent.putExtra("toShow", "launch");
                startActivity(intent);
                break;
            case R.id.btnNextLaunch:
                getNextLaunch();
                break;
            case R.id.btnLatestLaunch:
                getLatestLaunch();
                break;
            case R.id.btnShips:
                intent = new Intent(this, ListActivity.class);
                intent.putExtra("toShow", "ship");
                startActivity(intent);
                break;
            case R.id.btnCapsule:
                intent = new Intent(this, ChoicesListActivity.class);
                intent.putExtra("toShow", "capsule");
                startActivity(intent);
                break;
        }
    }

    public void getNextLaunch() {
        githubService.getNextLaunch().enqueue(new Callback<Launch>() {
            @Override
            public void onResponse(Call<Launch> call, Response<Launch> response) {
                launch = response.body();
                Intent intent = new Intent(MenuActivity.this, LaunchActivity.class);
                intent.putExtra("data", launch);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<Launch> call, Throwable t) {
            }
        });
    }

    public void getLatestLaunch() {
        githubService.getLatestLaunch().enqueue(new Callback<Launch>() {
            @Override
            public void onResponse(Call<Launch> call, Response<Launch> response) {
                launch = response.body();
                Intent intent = new Intent(MenuActivity.this, LaunchActivity.class);
                intent.putExtra("data", launch);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<Launch> call, Throwable t) {
            }
        });
    }
}