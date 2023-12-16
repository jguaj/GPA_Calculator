package com.example.gpa_calculator.model_package;

public class Lecture {

    String name;
    int weight;
    double gpa;

    public Lecture(String name, int weight, double gpa){
        this.name = name;
        this.weight = weight;
        this.gpa = gpa;
    }


    //GETTERS

    public String getName(){
        return this.name;
    }

    public int getWeight(){
        return this.weight;
    }

    public double getGpa(){
        return this.gpa;
    }


    //SETTERS

    public void setName(String name){
        this.name = name;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", gpa=" + gpa +
                '}';
    }
}
