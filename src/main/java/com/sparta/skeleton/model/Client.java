package com.sparta.skeleton.model;

import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.utilities.NonGaussianRandomBias;
import com.sparta.skeleton.utilities.TraineeHelper;

import java.util.ArrayList;

public class Client {

    private static int increment = 1;

    private final int clientID;
    private int countMonths = 0;
    private final ArrayList<Trainee> graduatesOnSite = new ArrayList<>();

    private final int traineeRequirement;

    private int currentTraineeRequirement;

    private final String[] requiredTraineeType;

    private boolean isHappy = true;

    public Client() {
        clientID = increment;
        requiredTraineeType = TraineeHelper.getRandomTraineeTypes(1);
        traineeRequirement = NonGaussianRandomBias.randomBiasGenerator();
        currentTraineeRequirement = traineeRequirement;
        increment++;
    }

    public ArrayList<Trainee> getTraineeList() {
        return graduatesOnSite;
    }

    public int getCountMonths() {
        return countMonths;
    }

    public boolean isHappy() {
        if ((countMonths % 12 != 0 || graduatesOnSite.size() >= currentTraineeRequirement) && isHappy) {
            return true;
        } else {
            isHappy = false;
            return false;
        }
    }

    public void setCurrentTraineeRequirement() {
        currentTraineeRequirement += traineeRequirement;
    }

    public void incrementMonth() {
        countMonths++;
    }

    public int getNumberOfGraduates() {
        return graduatesOnSite.size();
    }

    public int getTraineeRequirement() {
        return currentTraineeRequirement;
    }

    public String[] getRequiredTraineeType() {
        return requiredTraineeType;
    }

    public boolean addTrainee(Trainee trainee) {
        if(graduatesOnSite.size() < currentTraineeRequirement) {
            graduatesOnSite.add(trainee);
            return true;
        } else {
            return false;
        }
    }

    public int getClientID() {
        return clientID;
    }

}
