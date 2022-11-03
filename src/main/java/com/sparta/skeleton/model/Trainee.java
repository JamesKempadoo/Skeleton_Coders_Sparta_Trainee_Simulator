package com.sparta.skeleton.model;

import com.sparta.skeleton.utilities.TraineeHelper;

public class Trainee {

    private static int increment = 1;
    private final int traineeID;
    private final String courseType;

    public Trainee() {
        traineeID = increment;
        courseType = TraineeHelper.getRandomTraineeType();
        increment++;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public String getCourseType() {
        return courseType;
    }

}
