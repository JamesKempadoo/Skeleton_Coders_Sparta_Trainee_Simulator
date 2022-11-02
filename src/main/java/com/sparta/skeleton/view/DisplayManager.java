package com.sparta.skeleton.view;

import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;

import java.util.List;
import java.util.Queue;

public class DisplayManager {

    public static void displayConfigurationOptions() {
        System.out.print("""
                
                To run the simulation input one of the following options:
                                
                1.The name of the file that contains durations of multiple simulations
                2.Number of years to run a single simulation
                                
                Enter your input here:""");
    }

    public static void printOutput(Queue<Trainee> traineeWaitingList, List<TrainingCentre> trainingCentres, int numOfYears) {
        int trainingCentreNumber = trainingCentres.size();
        int fullTrainingCentre = getFullTrainingCentre(trainingCentres);
        int trainingTraineeNumber = getTrainingTraineeNumber(trainingCentres);
        int traineeWaitingListNumber = traineeWaitingList.size();


        System.out.println("The result of the simulation for " + numOfYears + " years:");
        System.out.println("Number of open centres: " + trainingCentreNumber);
        System.out.println("Number of full centres: " + fullTrainingCentre);
        System.out.println("Number of trainees currently training: " + trainingTraineeNumber);
        System.out.println("Number of trainees on the waiting list: " + traineeWaitingListNumber + "\n");

    }

    private static int getTrainingTraineeNumber(List<TrainingCentre> trainingCentres) {
        int trainingTraineeNumber = 0;
        for (TrainingCentre trainingCentre : trainingCentres) {
            trainingTraineeNumber += trainingCentre.getCurrentCapacity();
        }
        return trainingTraineeNumber;
    }

    private static int getFullTrainingCentre(List<TrainingCentre> trainingCentres) {
        int countOfFullCentres = 0;
        for (TrainingCentre trainingCentre : trainingCentres) {
            if (trainingCentre.trainingCentreIsFull())
                countOfFullCentres++;
        }
        return countOfFullCentres;
    }

    public static void printWrongInputMessage(String input) {
        System.out.println("Wrong input! Expected an integer greater than zero or the name of file and got \"" + input + "\"");
    }

    public static void displayExitOption() {
        System.out.print("Press 'n' to exit or any other key to run another simulation:");
    }

    public static void printErrorInFile(String s, int line) {
        System.out.println("Wrong input format in line " + line + "!\nExpected a positive integer and got \"" + s + "\"\n");
    }
}
