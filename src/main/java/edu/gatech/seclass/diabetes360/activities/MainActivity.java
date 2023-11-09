package edu.gatech.seclass.diabetes360.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.gatech.seclass.diabetes360.R;
import edu.gatech.seclass.diabetes360.core.OfferManager;

public class MainActivity extends Activity {

    private Button mEnterBloodSugarButton, mComparisonSettingsButton, mCompareJobsButton;
    OfferManager offerManager = OfferManager.getInstance();

    private TextView dateTimeTextView;
    private Handler handler = new Handler();
    private Runnable updateTimeRunnable;

    protected void refresh() {
        mCompareJobsButton.setEnabled(!offerManager.getOffers().isEmpty());
    }

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
        mComparisonSettingsButton = findViewById(R.id.btn_comparison_settings);
        mCompareJobsButton = findViewById(R.id.btn_compare_jobs);
        this.refresh();


        // Set button click listeners
        mEnterBloodSugarButton.setOnClickListener(view -> {
            // Open job offers menu
            Intent intent = new Intent(MainActivity.this, EnterJobOfferActivity.class);
            startActivity(intent);
        });

        mComparisonSettingsButton.setOnClickListener(view -> {
            // Open comparison settings menu
            Intent intent = new Intent(MainActivity.this, ComparisonSettingsActivity.class);
            startActivity(intent);
        });

        mCompareJobsButton.setOnClickListener(view -> {
            // Open compare jobs menu
            Intent intent = new Intent(MainActivity.this, CurrentJobActivity.class);
            startActivity(intent);
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