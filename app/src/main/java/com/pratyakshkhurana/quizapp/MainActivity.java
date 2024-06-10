package com.pratyakshkhurana.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton buttonStart = findViewById(R.id.buttonStart);
        EditText enterNameEditText = findViewById(R.id.enterNameEditText);

        buttonStart.setOnClickListener(v -> {
            if (enterNameEditText.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name !", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, QuizCategories.class);
                intent.putExtra("user", enterNameEditText.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

