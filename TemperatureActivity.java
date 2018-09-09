package com.example.localization.convertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class TemperatureActivity extends AppCompatActivity {
    // temperature field
    EditText temperature;
    // buttons
    RadioButton celToFah;
    RadioButton fahToCel;
    RadioButton celToKelv;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        // initializing variables in java file to variables in xml file
        celToFah = (RadioButton) findViewById(R.id.CelToFah);
        fahToCel = (RadioButton) findViewById(R.id.FahtoCel);
        celToKelv = (RadioButton) findViewById(R.id.CelToKelvin);
        temperature = (EditText) findViewById(R.id.tempText);
        convertButton = (Button) findViewById(R.id.convert);
        convertButton.setOnClickListener( new View.OnClickListener() {
            // allows a subclass (child) class to provide a specific implementation of a method
            // that is already provided by one of its super-classes or parent classes.
            @Override
            public void onClick(View v) {
                convert(v);
            }
        } );
    }

    public void convert(View v) {
        // retrieving the value entered in the temperature text field
        double value = new Double(temperature.getText().toString());
        if (celToFah.isChecked())
            value = celsiusToFahrenheit(value);
        else if (fahToCel.isChecked())
            value = fahrenheitToCelsius(value);
        // set the text back to the new value
        temperature.setText(new Double(value).toString());
    }
    public static double celsiusToFahrenheit(double celsius) {
        return 32 + celsius * (9 / 5);
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * (5 / 9);
    }

}

//once it's clicked let's get the Id's and then on click f the convert button do the converstions+
