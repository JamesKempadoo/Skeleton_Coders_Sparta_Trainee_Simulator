package com.sparta.skeleton.model;

import java.util.Random;

public class Trainee {
    private int traineeID = 1;
    private static int increment = 1;

    public String courseType = "";

    public Trainee() {
        traineeID = increment;
        increment++;
        courseType = setRandomCourseType();
    }

    public int getTraineeID() {
        return traineeID;
    }

    public String setRandomCourseType() {
        String[] courses = {"Java", "C#", "Data", "DevOps", "Business"};
        Random rng = new Random();
        return courses[rng.nextInt(courses.length)];
    }

    public String getCourseType() {
        return courseType;
    }

}
