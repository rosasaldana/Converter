package com.example.rosit.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
public class TemperatureActivity extends AppCompatActivity implements View.OnClickListener {

    View fromSelection = null;
    View toSelection = null;

    // the number the user wants to convert
    double tempNumber;
    // convert button
    Button convertButton;
    EditText temperatureInput;
    RadioButton fromKelvin, fromCelsius, fromFahrenheit, toKelvin, toCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        // temperature text input
        temperatureInput = findViewById(R.id.tempText);

        // FROM Selections
        fromKelvin = findViewById(R.id.kelvinButton);
        fromCelsius = findViewById(R.id.celsiusButton);
        fromFahrenheit = findViewById(R.id.fahrenheitButton);

        // TO Selections
        toKelvin = findViewById(R.id.KelvinButton2);
        toCelsius = findViewById(R.id.celsiusButton2);

        // FROM Selections clicked
        fromKelvin.setOnClickListener(this);
        fromCelsius.setOnClickListener(this);
        fromFahrenheit.setOnClickListener(this);

        // TO selections clicked
        toKelvin.setOnClickListener(this);
        toCelsius.setOnClickListener(this);

        convertButton = findViewById(R.id.convert);
        convertButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tempNumber = Integer.valueOf(temperatureInput.getText().toString());
        if (fromSelection == null) { fromSelection = v; return; }
        else if (toSelection == null) { toSelection = v; return; }
        else if (v.getId() == R.id.convert) { compute(tempNumber); }
        else { return; }

    }

    public void compute(double number) {
        // calculate the conversion
        int fromID = fromSelection.getId();
        int toID = toSelection.getId();
        if (fromID == R.id.kelvinButton) {
            if (toID == R.id.celsiusButton2){ tempNumber = tempNumber - 273.15; }
        }
        else if (fromID == R.id.celsiusButton){
            if (toID == R.id.KelvinButton2) { tempNumber = tempNumber + 273.15; }
        }
        else if (fromID == R.id.fahrenheitButton) {
            if (toID == R.id.KelvinButton2) {
                tempNumber = (tempNumber + 459.67)*(5/9);
            }
            else if (toID == R.id.celsiusButton2){
                tempNumber = (5/9)*(tempNumber - 32);
            }
        }
        // display the final number
        showToast(String.valueOf(tempNumber));
        // after calculations reset everything
        fromSelection = null;
        toSelection = null;
        return;
    }

    // printing the text to the screen
    private void showToast(String text) {
        Toast.makeText(TemperatureActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}

//once it's clicked let's get the Id's and then on click f the convert button do the converstions
