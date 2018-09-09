package com.example.rosit.convertercalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class WeightActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        // FROM Selections
        EditText weightText = findViewById(R.id.weightText);
        RadioButton fromGram = findViewById(R.id.gram);
        RadioButton fromPound = findViewById(R.id.pound);
        RadioButton fromOunce = findViewById(R.id.ounce);
        RadioButton fromKilogram = findViewById(R.id.kilogram);
        RadioButton fromMilligram = findViewById(R.id.milligram);

        fromGram.setOnClickListener(this);
        fromPound.setOnClickListener(this);
        fromOunce.setOnClickListener(this);
        fromKilogram.setOnClickListener(this);
        fromMilligram.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
