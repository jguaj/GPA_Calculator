package com.example.gpa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.gpa_calculator.controller_package.InputController;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        InputController inputController = new InputController(this);

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(inputController);

    }
}