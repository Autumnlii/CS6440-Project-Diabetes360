package edu.gatech.seclass.diabetes360.activities;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.diabetes360.R;

public class ViewExerciseDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise_data);

        LineChart lineChart = findViewById(R.id.lineChart);

        // Sample data
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 20));
        entries.add(new Entry(2, 45));
        entries.add(new Entry(3, 30));
        entries.add(new Entry(4, 60));
        entries.add(new Entry(5, 40));
        entries.add(new Entry(6, 0));
        entries.add(new Entry(7, 20));

        LineDataSet dataSet = new LineDataSet(entries, "Exercise Data"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.RED);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);

        // Customize chart
        lineChart.getDescription().setText("Last 7 Days Exercise Line Chart");
        lineChart.setNoDataText("No data available");
        lineChart.setNoDataTextColor(Color.BLACK);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return String.valueOf((int) value);
            }
        });

        YAxis yAxisLeft = lineChart.getAxisLeft();
        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setEnabled(false);

        // Refresh chart
        lineChart.invalidate();
    }
}