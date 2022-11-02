package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.controller.trainee.TraineeAllocationManager;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.Random;

public class TrainingCentreManager {


    public static void close(ArrayList<TrainingCentre> centres, Deque<Trainee> waitList, ArrayList<TrainingCentre> closedCentres){

        for (TrainingCentre centre : centres) { // check each centre that needs to be closed
            if (centre.getCurrentCapacity() < 25 && centre.isOverMaxMonths()){
                closeCentre(centre, waitList, closedCentres);
                centres.remove(centre);
            }
        }
    }

    public static void closeCentre(TrainingCentre centre, Deque<Trainee> waitList, ArrayList<TrainingCentre> closedCentres){
        TraineeAllocationManager.sendToFrontOfWaitList(centre, waitList);
        centre.getTraineeList().clear();


    }


    public static int getTraineeCount(ArrayList<TrainingCentre> trainingCentre) {
        return trainingCentre.size();
    }


    public static int populateTrainingCentre(Queue<Trainee> traineeQueue, TrainingCentre trainingCentre, int uptake) {
        int resultingUptake = uptake;
        int loopMax = Math.min(uptake, trainingCentre.getRemainingCapacity());

        for (int i =0; i<loopMax; i++){
            if (traineeQueue.size() < 1 || trainingCentre.trainingCentreIsFull()) {
                return resultingUptake;
            } else {
                trainingCentre.addTrainee(traineeQueue.remove());
                resultingUptake--;
            }
        }
        return resultingUptake;
    }

    public static int generateRandomTraineeUptake() {
        Random random = new Random();

        return random.nextInt(51);
    }

    //USER STORIES
    //trainees populate training centre
    //Full capacity Management
    //Prioritize waiting list (? ask if its in here)

}
