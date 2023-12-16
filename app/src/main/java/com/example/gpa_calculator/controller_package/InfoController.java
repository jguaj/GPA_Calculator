package com.example.gpa_calculator.controller_package;

import android.content.Intent;
import android.view.View;

import com.example.gpa_calculator.GPAActivity;
import com.example.gpa_calculator.InfoActivity;

public class InfoController implements View.OnClickListener{

    private InfoActivity infoActivity;

    public InfoController(InfoActivity infoActivity){
        this.infoActivity = infoActivity;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this.infoActivity, GPAActivity.class);
        infoActivity.startActivity(intent);
    }
}
