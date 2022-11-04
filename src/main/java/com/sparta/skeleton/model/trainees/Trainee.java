package com.sparta.skeleton.model.trainees;

import com.sparta.skeleton.utilities.TraineeHelper;

public class Trainee {

    private static int increment = 1;
    private final int traineeID;
    private final String courseType;

    private int monthsTrained = 0;

    public Trainee() {
        traineeID = increment;
        courseType = TraineeHelper.getRandomTraineeTypes(1)[0];
        increment++;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public String getCourseType() {
        return courseType;
    }

    public void incrementMonthsTrained() {
        monthsTrained++;
    }

    public int getMonthsTrained() {
        return monthsTrained;
    }

}
