package com.example.gpa_calculator.model_package;

import java.util.ArrayList;

public class Student {

    //name of the Student
    private String name = "User";
    //arrayList of Lecture objects
    private ArrayList<Lecture> lectures = new ArrayList<>();
    //GPA of the student
    private double GPA = 0.0;

    //using singleton design pattern
    //private static variable that is the only instance of the class
    private static Student studentInstance;

    /**
     * Private constructor to restrict instantiation of the class from other classes. Creates a
     * new Park instance with the given name.
     * @param name the name of the student.
     */
    private Student(String name) {
        this.name = name;
    }

    /**
     * public static method that returns the instance of the class, this is the global access point
     * the outer world to get the instance of the singleton class
     * @return the instance of the Student class.
     */
    public static Student getInstance() {
        if (studentInstance == null) {
            studentInstance = new Student("User");
            System.out.println("Student instance created");
        }
        return studentInstance;
    }

    @Override
    public String toString() {

        String s = "Student{" +
            "name='" + name + '\'' +
                    ", GPA=" + GPA +
                    '}';

        for(int i = 0; i < lectures.size(); ++i) {
            s += "\n\t\t" + lectures.get(i).toString();
        }

        return s;
    }

    /**
     * updates GPA of the student based on the weight and GPA of each lecture
     * if there are no lectures the student's GPA is 0
     * @return void
     */
    public void updateGPA() {
        double totalWeight = 0.0;
        double tmpGPA = 0.0;

        //if there are no classes in the ArrayList then the GPA is 0
        if(lectures.size() == 0) {
            tmpGPA = this.GPA;
            return;
        }

        //use weight and gpa of each lecture to calculate student gpa
        for(int i = 0; i < lectures.size(); ++i) {
            tmpGPA += lectures.get(i).getGpa() * lectures.get(i).getWeight();
            totalWeight += lectures.get(i).getWeight();
        }
        tmpGPA = tmpGPA/totalWeight;
        this.GPA = tmpGPA;
    }

    /**
     * Adds lecture to the student's list of lectures and updates the student's GPA
     * @param lecture the lecture to be added to the students list of lectures
     * @return void
     */
    public void addLecture(Lecture lecture) {
        //add lecture to lectures ArrayList
        lectures.add(lecture);

        //call to method updateGPA to update the gpa of the student
        updateGPA();
    }

    /**
     * Returns the name of the student.
     * @return the name of the student as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     * @param name the new name of the student
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns an ArrayList containing the lectures that the student is enrolled in.
     * @return an ArrayList of Lecture objects
     */
    public ArrayList<Lecture> getLectures() {
        return lectures;
    }

    /**
     * Sets the ArrayList of lectures that the student is enrolled in.
     * @param lectures the new ArrayList of Lecture objects
     * @return void
     */
    public void setLectures(ArrayList<Lecture> lectures) {
        this.lectures = lectures;
    }

    /**
     * Returns the GPA of the student.
     * @return the GPA of the student as a double
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Sets the GPA of the student.
     * @param GPA the new GPA of the student
     * @return void
     */
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
