package com.pratyakshkhurana.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    private TextView name;
    private TextView totalScore;
    private Button btnFinish;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        name = findViewById(R.id.name);
        totalScore = findViewById(R.id.totalScore);
        btnFinish = findViewById(R.id.btnFinish);

        name.setText(getIntent().getStringExtra("user"));
        int correct = getIntent().getIntExtra("correct", 0);
        totalScore.setText("You scored " + correct + " out of 10");

        btnFinish.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
