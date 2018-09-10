package com.example.rosit.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class LengthActivity extends AppCompatActivity {

    // weight field
    EditText lengthText;
    //result field
    TextView result;
    //buttons
    RadioButton footToIn;
    RadioButton inchToFoot;
    // convert button
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        footToIn = findViewById(R.id.footToInches);
        inchToFoot = findViewById(R.id.InchesToFoot);
        convertButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    convert(v);
            }
        });
    }

    public void convert(View v) {
        double value = new Double(lengthText.getText().toString());
        if(footToIn.isChecked()){
            value = footToInches(value);
        }
        else if (inchToFoot.isChecked()){
            value = inchesToFoot(value);
        }
        result.setText(new Double(value).toString());
    }

    public static double footToInches(double foot) {
        return foot*12;
    }
    public static double inchesToFoot(double inches) {
        double value = (double) 0.0833333;
        return value * inches;
    }
}
