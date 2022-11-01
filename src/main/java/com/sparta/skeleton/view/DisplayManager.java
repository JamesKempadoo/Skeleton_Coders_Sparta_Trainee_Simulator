package com.sparta.skeleton.view;

import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;

import java.util.List;
import java.util.Queue;

public class DisplayManager {
    public static void printQueryOfYear(){
        System.out.println("How long would you like the simulation to run for (in year)?");

    }

    public static void printOutput(Queue<Trainee> traineeWaitingList, List<TrainingCentre> trainingCentres){
        int trainingCentreNumber = trainingCentres.size();
        int fullTrainingCentre = getFullTrainingCentre(trainingCentres);
        int trainingTraineeNumber = getTrainingTraineeNumber(trainingCentres);
        int traineeWaitingListNumber = traineeWaitingList.size();


        System.out.println("The result of the simulation:");
        System.out.println("Number of open centres: " + trainingCentreNumber);
        System.out.println("Number of full centres: " + fullTrainingCentre);
        System.out.println("Number of trainees currently training: " + trainingTraineeNumber);
        System.out.println("Number of trainees on the waiting list: " + traineeWaitingListNumber);

    }

    private static int getTrainingTraineeNumber(List<TrainingCentre> trainingCentres) {
        int trainingTraineeNumber = 0;
        for (TrainingCentre trainingCentre : trainingCentres){
            trainingTraineeNumber +=  trainingCentre.getCurrentCapacity();
        }
        return trainingTraineeNumber;
    }

    private static int getFullTrainingCentre(List<TrainingCentre> trainingCentres) {
        int countOfFullCentres = 0;
        for (TrainingCentre trainingCentre : trainingCentres){
            if (trainingCentre.trainingCentreIsFull())
                countOfFullCentres++;
        }
        return countOfFullCentres;
    }

    public static void printWrongInputMessage(String input) {
        System.out.println("Wrong input! Expected an integer greater than zero and got \"" + input + "\"");
    }
}
