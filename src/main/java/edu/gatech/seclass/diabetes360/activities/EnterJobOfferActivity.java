package edu.gatech.seclass.diabetes360.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.gatech.seclass.diabetes360.R;
import edu.gatech.seclass.diabetes360.core.JobOffer;
import edu.gatech.seclass.diabetes360.core.Location;
import edu.gatech.seclass.diabetes360.core.OfferManager;

public class EnterBloodSugarActivity extends Activity {

    private OfferManager offerManager;
    private EditText titleEditText;
    private EditText companyEditText;
    private EditText cityEditText;
    private EditText stateEditText;
    private EditText costOfLivingEditText;

    private EditText salaryEditText;
    private EditText yearlyBonusEditText;
    private EditText stockAwardEditText;
    private EditText relocationEditText;
    private EditText personalChoiceHolidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_blood_sugar);
        offerManager = OfferManager.getInstance();
        titleEditText = findViewById(R.id.title_input);
        companyEditText = findViewById(R.id.company_input);

        Button saveAndCloseButton = findViewById(R.id.save_and_close);
        saveAndCloseButton.setOnClickListener(view -> {
            if (addOffer()) {
                Intent intent = new Intent(EnterJobOfferActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button saveAndNewButton = findViewById(R.id.save_and_create_another);
        saveAndNewButton.setOnClickListener(view -> {
            if (addOffer()) {
                Toast.makeText(EnterJobOfferActivity.this, "Job offer saved successfully", Toast.LENGTH_SHORT).show();
                titleEditText.setText("");
                companyEditText.setText("");
                cityEditText.setText("");
                stateEditText.setText("");
                costOfLivingEditText.setText("");
                salaryEditText.setText("");
                yearlyBonusEditText.setText("");
                stockAwardEditText.setText("");
                relocationEditText.setText("");
                personalChoiceHolidays.setText("");
            }
        });

        Button cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(view -> {
            if (addOffer()) {
                Intent intent = new Intent(EnterJobOfferActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean addBloodSugar() {
        String title = titleEditText.getText().toString().trim();
        String company = companyEditText.getText().toString().trim();
        String city = cityEditText.getText().toString().trim();
        String state = stateEditText.getText().toString().trim();
        String costOfLivingStr = costOfLivingEditText.getText().toString().trim();
        String salaryStr = salaryEditText.getText().toString().trim();
        String yearlyBonusStr = yearlyBonusEditText.getText().toString().trim();
        String stockStr = stockAwardEditText.getText().toString().trim();
        String relocationStr = relocationEditText.getText().toString().trim();
        String holidayStr = personalChoiceHolidays.getText().toString().trim();

        // Validate the values
        if (title.isEmpty() || company.isEmpty() || ) {
            Toast.makeText(EnterBloodSugarActivity.this, "Please enter all required fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        float salary = Float.parseFloat(salaryStr);
        int costOfLiving = Integer.parseInt(costOfLivingStr);
        float bonus = Float.parseFloat(yearlyBonusStr);
        float stocks = Float.parseFloat(stockStr);
        float relocation = Float.parseFloat(relocationStr);
        int holiday = Integer.parseInt(holidayStr);

        // Create a new JobOffer object
        JobOffer offer = new JobOffer(title, company, new Location(city, state, costOfLiving), salary, bonus, stocks, relocation, holiday, 0);

        // Add the new offer to the OfferManager
        offerManager.addOffer(offer);
        return true;
    }
}