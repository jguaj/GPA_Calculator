/**
 * InputController class is responsible for handling events and logic for InputActivity. It also
 * handles button clicks and navitates to the gpa activity view when the submit is clicked.
 * @author Jose Guajardo (zga887)
 */
package com.example.gpa_calculator.controller_package;

import static java.lang.Boolean.parseBoolean;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gpa_calculator.GPAActivity;
import com.example.gpa_calculator.InputActivity;
import com.example.gpa_calculator.R;
import com.example.gpa_calculator.model_package.Lecture;
import com.example.gpa_calculator.model_package.Student;

public class InputController implements View.OnClickListener {

    private InputActivity inputActivity;
    private Student studentInstance;

    public InputController(InputActivity activity) {
        inputActivity = activity;
        System.out.println("CCCC" + studentInstance);
        studentInstance = Student.getInstance();
        System.out.println("DDD" + studentInstance);
    }

    /**
     * @param view
     */
    @Override
    public void onClick(View view) {
        Intent intent;

        String validClassName = null;
        int validWeight = 0;
        double validGPA = 0.0;

        boolean validClassNameFlag = false;
        boolean validWeightFlag = false;
        boolean validGPAFlag = false;

        EditText enterNameEditText = inputActivity.findViewById(R.id.enterNameEditText);
        EditText enterWeightEditText = inputActivity.findViewById(R.id.enterWeightEditText);
        EditText enterGPAEditText = inputActivity.findViewById(R.id.enterGPAEditText);


        switch (view.getId()){
            case R.id.submitButton:
                System.out.println("submit button pressed");

                //check if class name is valid
                if(!String.valueOf(enterNameEditText.getText()).equals("")) {
                    validClassNameFlag = true;
                    validClassName = String.valueOf(enterNameEditText.getText());
                }

                //check if weight is a boolean
                if(String.valueOf(enterWeightEditText.getText()).matches("^[+]?\\d+$")) {
                    validWeightFlag = true;
                    validWeight = Integer.parseInt(String.valueOf(enterWeightEditText.getText()));
                }

                //check if gpa is valid
               if(String.valueOf(enterGPAEditText.getText()).matches("[+]?[0-9]*\\.?[0-9]+")) {
                    validGPAFlag = true;
                    validGPA = Double.parseDouble(String.valueOf(enterGPAEditText.getText()));
                }

                if(!validClassNameFlag) {
                    Toast t = Toast.makeText(view.getContext(), "ERROR: invalid class name", Toast.LENGTH_SHORT);
                    t.show();
                    break;
                }

                if(!validWeightFlag) {
                    Toast t = Toast.makeText(view.getContext(), "ERROR: invalid class weight", Toast.LENGTH_SHORT);
                    t.show();
                    break;
                }

                if(!validGPAFlag) {
                    Toast t = Toast.makeText(view.getContext(), "ERROR: invalid class GPA", Toast.LENGTH_SHORT);
                    t.show();
                    break;
                }

                if(validClassNameFlag && validGPAFlag && validWeightFlag) {
                    System.out.println("adding lecture to student");
                    studentInstance.addLecture(new Lecture(validClassName, validWeight, validGPA));
                    System.out.println(studentInstance);
                }

                intent = new Intent(inputActivity, GPAActivity.class);
                inputActivity.startActivity(intent);
                break;

            default:
                System.out.println("ERROR: in default for inputController");
        }
    }
}
