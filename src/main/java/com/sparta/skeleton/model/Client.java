package com.sparta.skeleton.model;

import com.sparta.skeleton.utilities.TraineeHelper;

import java.util.ArrayList;
import java.util.Random;

public class Client {

    private int countMonths = 0;
    private ArrayList<Trainee> clientList = new ArrayList<>();

    private int traineeRequirement;

    private String typeOfTrainee;

    public Client() {
        typeOfTrainee = setTypeOfTrainee();
        traineeRequirement = setTraineeRequirement();
    }

    public ArrayList<Trainee> getClientList() {
        return clientList;
    }

    public int getCountMonths() {
        return countMonths;
    }

    public boolean isHappy() {
        return countMonths > 12 && clientList.size() >= traineeRequirement;
    }

    public void incrementMonth() {
        countMonths++;
    }

    public int getTraineeRequirement() {
        return traineeRequirement;
    }

    public String getTypeOfTrainee() {
        return typeOfTrainee;
    }

    private String setTypeOfTrainee() {
        return TraineeHelper.getRandomTraineeType();
    }

    private int setTraineeRequirement() {
        Random rng = new Random();
        int delay;
        do {
            double val = rng.nextGaussian() * 100 + 15;
            delay = (int) Math.round(val);
        } while (delay <= 15);
        return delay;
    }

}
