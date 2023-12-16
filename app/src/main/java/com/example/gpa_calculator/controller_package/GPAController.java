/**
 * GPAController class is responsible for handling events and logic for GPAActivity. It also
 * handles button clicks and navitates to the inputActivity view when the addClassButton is clicked.
 * @author Jose Guajardo (zga887)
 */
package com.example.gpa_calculator.controller_package;

import android.content.Intent;
import android.view.View;

import com.example.gpa_calculator.GPAActivity;
import com.example.gpa_calculator.InputActivity;
import com.example.gpa_calculator.LectureListAdapter;
import com.example.gpa_calculator.R;
import com.example.gpa_calculator.model_package.Lecture;
import com.example.gpa_calculator.model_package.Student;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class GPAController implements View.OnClickListener {
    private GPAActivity gpaActivity;
    private Student studentInstance;

    /**
     * Constructor for GPAController. Takes in a GPAActivity object and sets it to
     * gpaActivity. Sets student to the Student instance.
     * @param activity the GPAActivity object to be used by the controller
     */
    public GPAController(GPAActivity activity) {
        gpaActivity = activity;
        studentInstance = Student.getInstance();
    }

    /**
     * Handles button clicks. When addClassButton is clicked, navigates to the InputActivity view.
     * @param view the view that was clicked
     * @return void
     */
    public void onClick(View view) {
        Intent intent;

        System.out.println(studentInstance);

        switch (view.getId()) {
            case R.id.addClassButton:
                System.out.println("\taddClassButton pressed");
                intent = new Intent(gpaActivity, InputActivity.class);
                gpaActivity.startActivity(intent);
                break;

            default:
                System.out.println("ERROR: Default Reached in GPAController");
        }
    }


    /**
     * display the GPA in the GPAActivity
     */
    public void updateGPAText() {
        TextView GPA = gpaActivity.findViewById(R.id.studentGPA);
        GPA.setText(String.format("%.2f", studentInstance.getGPA()));
    }

    /**
     * Displays the lectures and grades in the list view using the LectureListAdapter class.
     * @return void
     */
    public void displayClassesAndGrades() {

        ListView listView = gpaActivity.findViewById(R.id.listView);

        //get the array list of the lectures to be displayed
        ArrayList<Lecture> lectureArrayList = studentInstance.getLectures();

        //use the LectureListAdapter class to fill the rows in the list view with the correct format
        LectureListAdapter adapter = new LectureListAdapter(gpaActivity, R.layout.adapter_view_layout, lectureArrayList);
        listView.setAdapter(adapter);
    }
}
