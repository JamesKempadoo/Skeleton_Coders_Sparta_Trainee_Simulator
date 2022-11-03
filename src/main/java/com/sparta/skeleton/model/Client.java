package com.sparta.skeleton.model;

import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.utilities.NonGaussianRandomBias;
import com.sparta.skeleton.utilities.TraineeHelper;

import java.util.ArrayList;
import java.util.Random;

public class Client {

    private static int increment = 1;

    private final int clientID;
    private int countMonths = 0;
    private ArrayList<Trainee> clientList = new ArrayList<>();

    private final int traineeRequirement;

    private int currentTraineeRequirement;

    private String[] typeOfTrainee;

    public Client() {
        clientID = increment;
        typeOfTrainee = setTypeOfTrainee();
        traineeRequirement = setTraineeRequirement();
        currentTraineeRequirement = traineeRequirement;
        increment++;
    }

    public Client(int traineeRequirement) {
        clientID = increment;
        typeOfTrainee = setTypeOfTrainee();
        this.traineeRequirement = traineeRequirement;
        currentTraineeRequirement = traineeRequirement;
        increment++;
    }

    public ArrayList<Trainee> getTraineeList() {
        return clientList;
    }

    public int getCountMonths() {
        return countMonths;
    }

    public boolean isHappy() {
        return countMonths % 12 != 0 || clientList.size() >= currentTraineeRequirement;
    }

    public void setCurrentTraineeRequirement() {
        currentTraineeRequirement += traineeRequirement;
    }

    public void incrementMonth() {
        countMonths++;
    }

    public int getNumberOfGraduates() {
        return clientList.size();
    }

    public int getTraineeRequirement() {
        return currentTraineeRequirement;
    }

    public String[] getTypeOfTrainee() {
        return typeOfTrainee;
    }

    private String[] setTypeOfTrainee() {
        return new String[]{TraineeHelper.getRandomTraineeType()};
    }

    private int setTraineeRequirement() {
//        Random rng = new Random();
//        int delay;
//        do {
//            double val = rng.nextGaussian() * 100 + 15;
//            delay = (int) Math.round(val);
//        } while (delay <= 15);
//        return delay;
        return NonGaussianRandomBias.randomBiasGenerator();
    }

    public void addTrainee(Trainee trainee) {
        if(clientList.size() < traineeRequirement) {
            clientList.add(trainee);
        }
    }

    public int getClientID() {
        return clientID;
    }

}
