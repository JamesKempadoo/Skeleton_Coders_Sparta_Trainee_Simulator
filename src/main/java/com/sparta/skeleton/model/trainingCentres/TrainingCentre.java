package com.sparta.skeleton.model.trainingCentres;

import com.sparta.skeleton.model.trainees.Trainee;

import java.util.ArrayList;

public abstract class TrainingCentre {
    protected final int trainingCentreID;
    protected static int increment = 1;
    protected int countMonths = 0;
    protected ArrayList<Trainee> traineesList = new ArrayList<>();
    protected String[] courseTypes;

    public TrainingCentre() {
        trainingCentreID = increment;
        increment++;
    }

    public int getCurrentCapacity() {
        return traineesList.size();
    }
    public int getRemainingCapacity() {
        return getMaxCapacity()- traineesList.size();
    }

    public boolean trainingCentreIsFull() {
        return getMaxCapacity() == traineesList.size();
    }

    public void addTrainee(Trainee trainee) {
        if(traineesList.size() < getMaxCapacity()) {
            traineesList.add(trainee);
        }
    }

    public int getTrainingCentreID() {
        return trainingCentreID;
    }

    public ArrayList<Trainee> getTraineesList() {
        return traineesList;
    }

    public void incrementMonth() {
        countMonths++;
    }

    public boolean isOverMaxMonths() {
        return countMonths >= getMaxMonths();
    }

    public String[] getCourseTypes() {
        return courseTypes;
    }

    public void setCourseType(String[] courseType) {
        this.courseTypes = courseType;
    }

    public abstract int getMaxMonths();

    public abstract int getMaxCapacity();


}
