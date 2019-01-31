package com.alexandreexample.spacexapp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.alexandreexample.spacexapp.Models.Launch;
import com.alexandreexample.spacexapp.Models.Rocket;
import com.alexandreexample.spacexapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.alexandreexample.spacexapp.Controls.GithubService.githubService;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity);
        TextView mTextView = findViewById(R.id.textView);

        Intent intent = getIntent();
        Launch launch = (Launch) intent.getSerializableExtra("data");

        setTitle(launch.getMissionName());
        mTextView.setText(launch.getDetails());

    }


}
