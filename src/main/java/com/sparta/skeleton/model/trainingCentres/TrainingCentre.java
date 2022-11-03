package com.sparta.skeleton.model.trainingCentres;

import com.sparta.skeleton.model.Trainee;

import java.util.ArrayList;

public abstract class TrainingCentre {

    int trainingCentreID;
    static int increment = 1;

    protected int maxCapacity;
    protected ArrayList<Trainee> traineeList = new ArrayList<>();

    protected int countMonths = 0;

    protected int maxMonths;

    protected String[] courseTypes;

    public TrainingCentre(int maxCapacity, int maxMonths) {
        trainingCentreID = increment;
        increment++;
        this.maxCapacity = maxCapacity;
        this.maxMonths = maxMonths;
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

    public void incrementMonth() {
        countMonths++;
    }

    public boolean isOverMaxMonths() {
        return countMonths >= maxMonths;
    }

    public String[] getCourseTypes() {
        return courseTypes;
    }

    public void setCourseType(String[] courseType) {
        this.courseTypes = courseType;
    }


}
