package com.sparta.skeleton.model;

import java.util.ArrayList;

public class TrainingCentre {

    int trainingCentreID = 1;
    static int increment = 1;
    private final int maxCapacity = 100;
    private ArrayList<Trainee> traineeList = new ArrayList<>();

    public TrainingCentre() {
        trainingCentreID = increment;
        increment++;
    }

    public int getCurrentCapacity() {
        return traineeList.size();
    }
    public int getRemainingCapacity() {
        return maxCapacity-traineeList.size();
    }

    public boolean trainingCentreIsFull() {
        return maxCapacity == traineeList.size();
    }

    public void addTrainee(Trainee trainee) {
        if(traineeList.size() < maxCapacity) {
            traineeList.add(trainee);
        }
    }

    public int getTrainingCentreID() {
        return trainingCentreID;
    }

    public ArrayList<Trainee> getTraineeList() {
        return traineeList;
    }


}
