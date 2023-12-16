package com.example.gpa_calculator.controller_package;

import android.content.Intent;
import android.view.View;

import com.example.gpa_calculator.GPAActivity;
import com.example.gpa_calculator.InfoActivity;
import com.example.gpa_calculator.MainActivity;
import com.example.gpa_calculator.R;


/**
 * controller used for the MainActivity; sends the user to either InfoActivity or GPAActivity depending
 * on the button that was pressed.
 */
public class MainController implements View.OnClickListener{

    //given mainActivity for context
    private MainActivity mainActivity;

    public MainController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }


    /**
     * method that determines the button pressed, and sends the user to the corresponding activity.
     * @param view - Button the user presses.
     */
    @Override
    public void onClick(View view) {

        Intent intent;

        switch(view.getId()) {
            case R.id.enter_button:
                intent = new Intent(this.mainActivity, GPAActivity.class);
                mainActivity.startActivity(intent);
                break;
            case R.id.info_button:
                intent = new Intent(this.mainActivity, InfoActivity.class);
                mainActivity.startActivity(intent);
                break;
        }
    }
}
