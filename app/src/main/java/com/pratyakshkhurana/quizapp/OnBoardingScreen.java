package com.pratyakshkhurana.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class OnBoardingScreen extends AppCompatActivity {
    private AdapterViewPager onBoardingAdapter;
    private TabLayout tabLayout;
    private ViewPager onBoardingPager;
    private TextView next;
    private int position = 0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);

        tabLayout = findViewById(R.id.tabLayout);
        next = findViewById(R.id.nextMove);

        // Adding Data
        ArrayList<OnBoardIngItems> onBoardIngData = new ArrayList<>();
        onBoardIngData.add(new OnBoardIngItems(R.drawable.topic_display, "Different Subjects for the Quiz"));
        onBoardIngData.add(new OnBoardIngItems(R.drawable.questions_display, "Simple User Interface for the Quiz"));
        setOnBoardingViewPagerAdapter(onBoardIngData);

        position = onBoardingPager.getCurrentItem();
        next.setOnClickListener(v -> {
            if (position < onBoardIngData.size()) {
                position++;
                onBoardingPager.setCurrentItem(position);
            }
            if (position == onBoardIngData.size()) {
                savePrefData();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (tab.getPosition() == onBoardIngData.size() - 1) {
                    next.setText("Get Started");
                } else {
                    next.setText("Next");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Not yet implemented
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Not yet implemented
            }
        });
    }

    private void setOnBoardingViewPagerAdapter(ArrayList<OnBoardIngItems> onBoardIngItems) {
        onBoardingPager = findViewById(R.id.screenPager);
        onBoardingAdapter = new AdapterViewPager(this, onBoardIngItems);
        onBoardingPager.setAdapter(onBoardingAdapter);
        tabLayout.setupWithViewPager(onBoardingPager);
    }

    private void savePrefData() {
        sharedPreferences = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isFirstTimeRun", true);
        editor.apply();
    }

    private boolean restorePrefData() {
        sharedPreferences = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("isFirstTimeRun", false);
    }
}
