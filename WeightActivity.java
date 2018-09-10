package com.example.rosit.converter;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class WeightActivity extends AppCompatActivity {

    // weight field
    EditText weight;
    //result field
    TextView result;
    // buttons
    RadioButton gramTolb;
    RadioButton lbToGram;
    RadioButton ounceToGram;
    RadioButton gramToOunce;
    RadioButton ounceTolb;
    RadioButton lbToOunce;
    RadioButton gramToKilo;
    RadioButton gramToMilligram;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gramTolb = findViewById(R.id.gramToPound);
        lbToGram = findViewById(R.id.poundToGram);
        ounceToGram = findViewById(R.id.ounceToGram);
        gramToOunce = findViewById(R.id.gramToOunce);
        ounceTolb = findViewById(R.id.ounceToPound);
        lbToOunce = findViewById(R.id.poundToOunce);
        convertButton =  findViewById(R.id.convert);
        gramToKilo = findViewById(R.id.gramToKilo);
        gramToMilligram = findViewById(R.id.gramToMilligram);

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
        double value = new Double(weight.getText().toString());
        if (gramTolb.isChecked()) {
            value = gramToPound(value);
        }
        else if(lbToGram.isChecked()) {
            value = poundToGram(value);
        }
        else if (ounceToGram.isChecked()) {
            value = ounceToGram(value);
        }
        else if (gramToOunce.isChecked()) {
            value = gramToOunce(value);
        }
        else if (ounceTolb.isChecked()) {
            value = ounceToPound(value);
        }
        else if (lbToOunce.isChecked()) {
            value = poundToOunce(value);
        }
        else if (gramToKilo.isChecked()){
            value = gramToKilogram(value);
        }
        else if (gramToMilligram.isChecked()){
            value = gramToMilligram(value);
        }
        result.setText(new Double(value).toString());
    }

    public static double gramToPound(double gram){
        double value = (double) 0.002204622621849;
        return gram * value;
    }
    public static double poundToGram(double pound){
        double value = (double) 453.59237;
        return pound * value;
    }
    public static double ounceToGram(double ounce){
        double value = (double) 28.349523125;
        return ounce * value;
    }
    public static double gramToOunce(double gram) {
        double value = (double) 0.03527396194958;
        return gram * value;
    }
    public static double ounceToPound(double ounce){
        double value = (double) 0.0625;
        return ounce * value;
    }
    public static double poundToOunce(double pound){
        double value = (double) 16;
        return pound * value;
    }
    public static double gramToKilogram(double gram){
        double value = (double) 0.001;
        return gram * value;
    }
    public static double gramToMilligram(double gram){
        double value = (double) 1000;
        return gram * value;
    }
}
