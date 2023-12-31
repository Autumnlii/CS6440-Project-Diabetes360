package edu.gatech.seclass.diabetes360.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.gatech.seclass.diabetes360.R;

public class MainActivity extends Activity {

    private Button mEnterBloodSugarButton, mEnterExerciseButton, mEnterMedicationButton,
            mViewBloodSugarDataButton, mViewExerciseDataButton, mEnterContact, mSendData;//, mComparisonSettingsButton, mCompareJobsButton;

    private TextView dateTimeTextView;
    private Handler handler = new Handler();
    private Runnable updateTimeRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextView by its ID
        dateTimeTextView = findViewById(R.id.date_time_textview);


        // Initialize the Runnable to update the time
        updateTimeRunnable = new Runnable() {
            @Override
            public void run() {
                updateDateTime();
                handler.postDelayed(this, 60000); // Update every 1 second (1000 milliseconds)
            }
        };

        // Start updating the time
        handler.post(updateTimeRunnable);
        // Initialize buttons
        mEnterBloodSugarButton = findViewById(R.id.btn_enter_blood_sugar);

        // Set button click listeners
        mEnterBloodSugarButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EnterBloodSugarActivity.class);
            startActivity(intent);
        });

        mEnterExerciseButton = findViewById(R.id.btn_enter_exercise);

        // Set button click listeners
        mEnterExerciseButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EnterExerciseActivity.class);
            startActivity(intent);
        });

        mEnterMedicationButton = findViewById(R.id.btn_enter_medication);

        // Set button click listeners
        mEnterMedicationButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EnterMedicationActivity.class);
            startActivity(intent);
        });

        mViewBloodSugarDataButton = findViewById(R.id.btn_view_blood_sugar_data);

        // Set button click listeners
        mViewBloodSugarDataButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewBloodSugarDataActivity.class);
            startActivity(intent);
        });

        mViewExerciseDataButton = findViewById(R.id.btn_view_exercise_data);

        // Set button click listeners
        mViewExerciseDataButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewExerciseDataActivity.class);
            startActivity(intent);
        });


        mEnterContact = findViewById(R.id.btn_enter_contact);

        // Set button click listeners
        mEnterContact.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EnterContactActivity.class);
            startActivity(intent);
        });

        mSendData = findViewById(R.id.btn_send_data);

        // Set button click listeners
        mSendData.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Sending health data to contacts", Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the handler when the activity is destroyed to avoid memory leaks
        handler.removeCallbacks(updateTimeRunnable);
    }

    private void updateDateTime() {
        // Get the current date and time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentDateAndTime = sdf.format(new Date());

        // Set the current date and time in the TextView
        dateTimeTextView.setText("Current Date and Time: " + currentDateAndTime);
    }
}