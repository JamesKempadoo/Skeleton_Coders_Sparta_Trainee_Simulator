package com.sparta.skeleton.model;

public class Trainee {
    private int traineeID = 1;
    private static int increment = 1;

    public Trainee() {
        traineeID = increment;
        increment++;
    }

    public int getTraineeID() {
        return traineeID;
    }

}
