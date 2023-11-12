package edu.gatech.seclass.diabetes360.activities;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.gatech.seclass.diabetes360.R;
import edu.gatech.seclass.diabetes360.core.BloodSugarEntry;
import edu.gatech.seclass.diabetes360.core.DatabaseHelper;

public class EnterBloodSugarActivity extends Activity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    private EditText monthEditText;
    private EditText dayEditText;
    private EditText valueEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_blood_sugar);
        monthEditText = findViewById(R.id.month);
        dayEditText = findViewById(R.id.day);
        valueEditText = findViewById(R.id.value);

        Button saveAndCloseButton = findViewById(R.id.save_and_close);
        saveAndCloseButton.setOnClickListener(view -> {
            if (addBloodSugar()) {
                Intent intent = new Intent(EnterBloodSugarActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button saveAndNewButton = findViewById(R.id.save_and_create_another);
        saveAndNewButton.setOnClickListener(view -> {
            if (addBloodSugar()) {
                Toast.makeText(EnterBloodSugarActivity.this, "Blood Sugar Entry saved successfully", Toast.LENGTH_SHORT).show();
                monthEditText.setText("");
                dayEditText.setText("");
                valueEditText.setText("");
            }
        });

        Button cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(view -> {
            Intent intent = new Intent(EnterBloodSugarActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private boolean addBloodSugar() {
        String month = monthEditText.getText().toString().trim();
        String day = dayEditText.getText().toString().trim();
        String value = valueEditText.getText().toString().trim();

        int validatedMonth;
        int validatedDay;
        int validatedValue;

        try {
            // Validate the values
            validatedMonth = Integer.parseInt(month);
            validatedDay = Integer.parseInt(day);
            validatedValue = Integer.parseInt(value);

        } catch (Exception e) {
            Toast.makeText(EnterBloodSugarActivity.this, "Please enter all required " +
                    "fields in the correct format", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Create a new Blood Sugar object
        BloodSugarEntry offer = new BloodSugarEntry(validatedMonth, validatedDay, validatedValue);

        // Open the database for reading and writing
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        databaseHelper.onCreate(db);

        // Perform database operations (e.g., insert, query, update, delete)
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.MONTH, validatedMonth);
        values.put(DatabaseHelper.DAY, validatedDay);
        values.put(DatabaseHelper.VALUE, validatedValue);
        db.insert(DatabaseHelper.TABLE_NAME_BS, null, values);

        // Close the database when done
        db.close();
        databaseHelper.debug(DatabaseHelper.TABLE_NAME_BS);
        return true;
    }
}