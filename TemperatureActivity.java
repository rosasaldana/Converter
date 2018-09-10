package com.example.localization.convertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class TemperatureActivity extends AppCompatActivity {
    // temperature field
    EditText temperature;
    // result field
    TextView result;
    // buttons
    RadioButton celToFah;
    RadioButton fahToCel;
    RadioButton celToKelv;
    RadioButton kelvToCel;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        // initializing variables in java file to variables in xml file
        celToFah = (RadioButton) findViewById(R.id.CelToFah);
        fahToCel = (RadioButton) findViewById(R.id.FahtoCel);
        celToKelv = (RadioButton) findViewById(R.id.celToKelvin);
        temperature = (EditText) findViewById(R.id.tempText);
        kelvToCel = (RadioButton) findViewById(R.id.KelvToCel);
        result = (TextView) findViewById(R.id.result);

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
        else if (celToKelv.isChecked())
            value = celsiusToKelvin(value);
        else if (kelvToCel.isChecked())
            value = kelvinToCelsius(value);
        // set the text back to the new value
        // temperature.setText(new Double(value).toString());
        result.setText(new Double(value).toString());
    }
    public static double celsiusToFahrenheit(double celsius) {
        double value = (double) celsius * 1.8;
        return 32 + value;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double value =  0.55555555555;
        return (fahrenheit - 32) * value;
    }
    public static double celsiusToKelvin(double c) {
        double value = 273.15;
        return c + value;
    }
    public static double kelvinToCelsius(double k){
        double value = 273.15;
        return k - value;
    }
}
