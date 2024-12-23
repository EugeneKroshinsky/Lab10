package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;
    private TextView resultField;
    private Spinner unitSpinner;
    private String selectedUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
        resultField = findViewById(R.id.resultField);
        unitSpinner = findViewById(R.id.unitSpinner);

        // Настройка Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.units_array, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        unitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedUnit = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedUnit = "Gallons to Liters";
            }
        });
    }

    public void onConvertClick(View view) {
        String inputText = inputField.getText().toString();
        if (inputText.isEmpty()) {
            resultField.setText("Please enter a value.");
            return;
        }

        double input = Double.parseDouble(inputText);
        double result = ConverterUtils.convert(input, selectedUnit);
        resultField.setText(String.format("%.2f", result));
    }
}

