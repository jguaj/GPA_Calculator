/**
 * GPAActivity shows the activity_gpaactivity.xml.
 * gpa activity should create a new GPAController and connect each button to the GUI with
 * the controller.
 * @author Jose Guajardo (zga887)
 */
package com.example.gpa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.gpa_calculator.controller_package.GPAController;

public class GPAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpaactivity);

        System.out.println("in GPAActivity");

        //create instance of GPAController that contains the methods needed for this activity
        GPAController GPAController = new GPAController(this);

        //create relocation button and set the on click listener
        ImageButton addClassButton = findViewById(R.id.addClassButton);
        addClassButton.setOnClickListener(GPAController);

        GPAController.updateGPAText();
        GPAController.displayClassesAndGrades();
    }
}