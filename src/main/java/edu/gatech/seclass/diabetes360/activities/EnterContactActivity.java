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
import edu.gatech.seclass.diabetes360.core.DatabaseHelper;

public class EnterContactActivity extends Activity {
    
    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    private EditText emailEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_contact);
        emailEditText = findViewById(R.id.contact_email);

        Button saveAndCloseButton = findViewById(R.id.save_and_close);
        saveAndCloseButton.setOnClickListener(view -> {
            if (addContact()) {
                Intent intent = new Intent(EnterContactActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button saveAndNewButton = findViewById(R.id.save_and_create_another);
        saveAndNewButton.setOnClickListener(view -> {
            if (addContact()) {
                Toast.makeText(EnterContactActivity.this, "Contact email saved successfully", Toast.LENGTH_SHORT).show();
                emailEditText.setText("");
            }
        });

        Button cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(view -> {
            Intent intent = new Intent(EnterContactActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private boolean addContact() {
        String email = emailEditText.getText().toString().trim();

        if(!email.contains("@")) {
            Toast.makeText(EnterContactActivity.this, "Please enter all required " +
                    "fields in the correct format", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}