package com.pratyakshkhurana.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreferences = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);

        new Handler().postDelayed(() -> {
            if (sharedPreferences.getBoolean("isFirstTimeRun", false)) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            } else {
                startActivity(new Intent(getApplicationContext(), OnBoardingScreen.class));
                finish();
            }
        }, 1000);
    }
}
