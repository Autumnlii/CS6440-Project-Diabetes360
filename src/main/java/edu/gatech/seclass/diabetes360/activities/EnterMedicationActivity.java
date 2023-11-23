package edu.gatech.seclass.diabetes360.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import edu.gatech.seclass.diabetes360.R;

public class EnterMedicationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_medication);

        Button yesButton = findViewById(R.id.yes_button);
        yesButton.setOnClickListener(view -> {
            Toast.makeText(EnterMedicationActivity.this, "Yes answer recorded", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EnterMedicationActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        Button noButton = findViewById(R.id.no_button);
        noButton.setOnClickListener(view -> {
            Toast.makeText(EnterMedicationActivity.this, "No answer recorded", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EnterMedicationActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        Button cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(view -> {
            Intent intent = new Intent(EnterMedicationActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}