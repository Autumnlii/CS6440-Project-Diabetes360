package edu.gatech.seclass.diabetes360.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.gatech.seclass.diabetes360.R;
import edu.gatech.seclass.diabetes360.core.OfferManager;

import java.util.Map;

public class ComparisonSettingsActivity extends Activity {

    private OfferManager offerManager = OfferManager.getInstance();
    private Map<String, Number> weights;

    private EditText yearlySalaryEditText;
    private EditText yearlyBonusEditText;
    private EditText restrictedStockUnitAwardEditText;
    private EditText relocationStipendEditText;
    private EditText holidaysEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_settings);

        // Get the shared preferences for saving the comparison weights
        weights = offerManager.getWeights();
        // Get references to the UI elements for setting the weights
        yearlySalaryEditText = findViewById(R.id.yearlySalaryEditText);
        yearlyBonusEditText = findViewById(R.id.yearlyBonusEditText);
        restrictedStockUnitAwardEditText = findViewById(R.id.restrictedStockUnitAwardEditText);
        relocationStipendEditText = findViewById(R.id.relocationStipendEditText);
        holidaysEditText = findViewById(R.id.holidaysEditText);

        // Set the initial values for the weight fields
        readWeights();

        // Get references to the save and close buttons and set click listeners
        Button saveButton = findViewById(R.id.ok_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveWeights();
                Toast.makeText(ComparisonSettingsActivity.this, "Comparison settings saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button closeButton = findViewById(R.id.cancel_button);
        closeButton.setOnClickListener(v -> finish());
    }

    private void readWeights() {
        yearlySalaryEditText.setText(String.valueOf(weights.getOrDefault("yearly_salary_weight", 1f)));
        yearlyBonusEditText.setText(String.valueOf(weights.getOrDefault("yearly_bonus_weight", 1f)));
        restrictedStockUnitAwardEditText.setText(String.valueOf(weights.getOrDefault("restricted_stock_unit_award_weight", 1f)));
        relocationStipendEditText.setText(String.valueOf(weights.getOrDefault("relocation_stipend_weight", 1f)));
        holidaysEditText.setText(String.valueOf(weights.getOrDefault("holidays_weight", 1)));
    }

    private void saveWeights() {
        float yearlySalaryWeight = Float.parseFloat(yearlySalaryEditText.getText().toString());
        float yearlyBonusWeight = Float.parseFloat(yearlyBonusEditText.getText().toString());
        float restrictedStockUnitAwardWeight = Float.parseFloat(restrictedStockUnitAwardEditText.getText().toString());
        float relocationStipendWeight = Float.parseFloat(relocationStipendEditText.getText().toString());
        int holidaysWeight = Integer.parseInt(holidaysEditText.getText().toString());

        offerManager.getWeights().put("yearly_salary_weight", yearlySalaryWeight);
        offerManager.getWeights().put("yearly_bonus_weight", yearlyBonusWeight);
        offerManager.getWeights().put("restricted_stock_unit_award_weight", restrictedStockUnitAwardWeight);
        offerManager.getWeights().put("relocation_stipend_weight", relocationStipendWeight);
        offerManager.getWeights().put("holidays_weight", holidaysWeight);
    }

}