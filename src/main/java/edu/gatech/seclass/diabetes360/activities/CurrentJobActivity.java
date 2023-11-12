//package edu.gatech.seclass.diabetes360.activities;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import edu.gatech.seclass.diabetes360.R;
//
//public class CurrentJobActivity extends Activity {
//
//    private Button mCancelButton;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_current_job);
//        mCancelButton = findViewById(R.id.cancel_button);
//
//        mCancelButton.setOnClickListener(view -> {
//            // Open current job menu
//            Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
//            startActivity(intent);
//        });
//
//    }
//}