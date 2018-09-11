package com.example.localization.convertor;

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
    RadioButton gramToKilo;
    RadioButton kilo_to_gram;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        gramToKilo = findViewById(R.id.gramTokilo);
        kilo_to_gram = findViewById(R.id.KiloToGram);
        convertButton = findViewById(R.id.convert);
        weight = (EditText) findViewById(R.id.weightText);
        result = findViewById(R.id.result);

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
        if (gramToKilo.isChecked()) {
            value = gramToKilogram(value);
        }
        else if(kilo_to_gram.isChecked()) {
            value = kilogramToGram(value);
        }
        result.setText(new Double(value).toString());
    }

    public static double gramToKilogram(double gram){
        double value = (double) 0.001;
        return gram * value;
    }
    public static double kilogramToGram(double kilo){
        double value = (double) 1000;
        return kilo * value;
    }
}
