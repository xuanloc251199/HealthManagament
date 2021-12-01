package com.vinh.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    CardView mCvBMI, mCvWater, mCvProfile, mCvSleep, mCvExercise, mCvSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        onInit();

        onCardviewClickListener();
    }

    private void onInit() {
        mCvBMI = findViewById(R.id.cvBMI);
        mCvWater = findViewById(R.id.cvWater);
        mCvProfile = findViewById(R.id.cvProfile);
        mCvExercise = findViewById(R.id.cvExercise);
        mCvSchedule = findViewById(R.id.cvSchedule);
        mCvSleep = findViewById(R.id.cvSleep);
    }

    private void onCardviewClickListener() {
        mCvBMI.setOnClickListener(v -> {
            Intent intent = new Intent(this, BMIActivity.class);
            startActivity(intent);
        });

        mCvWater.setOnClickListener(v -> {
            Intent intent = new Intent(this, WaterActivity.class);
            startActivity(intent);
        });

        mCvSleep.setOnClickListener(v -> {
            Intent intent = new Intent(this, SleepActivity.class);
            startActivity(intent);
        });

        mCvExercise.setOnClickListener(v -> {
            Intent intent = new Intent(this, ExerciseActivity.class);
            startActivity(intent);
        });

        mCvSchedule.setOnClickListener(v -> {
            Intent intent = new Intent(this, ScheduleActivity.class);
            startActivity(intent);
        });

        mCvProfile.setOnClickListener(v -> {
            Intent intent= new Intent(HomeActivity.this, ProfileActivity.class);
            String user = getIntent().getStringExtra("keyUsername");
            intent.putExtra("keyUsername", user);
            startActivity(intent);
        });
    }
}