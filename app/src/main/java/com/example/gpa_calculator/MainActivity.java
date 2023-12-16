package com.example.gpa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gpa_calculator.controller_package.MainController;
import com.example.gpa_calculator.model_package.Lecture;
import com.example.gpa_calculator.model_package.Student;

/**
 * displays the main menu of the application; also provides user buttons to navigate to either
 * the information page or the GPA page.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainController mainController = new MainController(this);

        Button enter_button = (Button) findViewById(R.id.enter_button);
        enter_button.setOnClickListener(mainController);

        ImageButton info_button = (ImageButton) findViewById(R.id.info_button);
        info_button.setOnClickListener(mainController);

    }
}