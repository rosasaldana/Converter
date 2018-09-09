package com.example.rosit.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // buttons in the main menu
    private Button lengthButton;
    private Button weightButton;
    private Button tempButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // associate buttons by id in activity_main.xml
        // NOTE: must cast it to a button
        lengthButton = (Button) findViewById(R.id.lengthButton);
        weightButton = (Button) findViewById(R.id.weightButton);
        tempButton = (Button) findViewById(R.id.tempButton);

        // setting the functionality for when the button is clicked
        // lengthButton is listening/waiting to see when it's clicked
        // OnClickListener is a callback function - when button is clicked the function
        // inside will execute automatically
        lengthButton.setOnClickListener( new View.OnClickListener() {
                                             // allows a subclass (child) class to provide a specific implementation of a method
                                             // that is already provided by one of its super-classes or parent classes.
                                             @Override
                                             public void onClick (View v) {
                                                 openLengthActivity();
                                             }
                                         }
        );

        weightButton.setOnClickListener( new View.OnClickListener() {
                                             @Override
                                             public void onClick ( View v ) {
                                                 openWeightActivity();
                                             }
                                         }
        );

        tempButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                openTemperatureActivity();
            }
        });
    }

    public void openLengthActivity() {
        // must create an Intent to open activity
     //   Intent intent = new Intent(this, LengthActivity.class);
    //    startActivity(intent);
    }

    public void openWeightActivity() {
   //     Intent intent = new Intent( this, WeightActivity.class);
   //     startActivity(intent);
    }

    public void openTemperatureActivity() {
        Intent intent = new Intent( this, TemperatureActivity.class);
        startActivity(intent);
    }
}
