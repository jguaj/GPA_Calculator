package com.example.gpa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.gpa_calculator.controller_package.InfoController;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        InfoController infoController = new InfoController(this);

        Button enter_button = (Button) findViewById(R.id.enter_button);
        enter_button.setOnClickListener(infoController);

    }
}