package com.alexandreexample.spacexapp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.alexandreexample.spacexapp.Models.Capsule;
import com.alexandreexample.spacexapp.R;


public class CapsuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capsule_activity);
        TextView mTextView = findViewById(R.id.textView);

        Intent intent = getIntent();
        Capsule capsule = (Capsule) intent.getSerializableExtra("data");

        setTitle(capsule.getCapsuleId());
        mTextView.setText(capsule.getDetails());

    }
}
