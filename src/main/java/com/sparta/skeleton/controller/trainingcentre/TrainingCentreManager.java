package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class TrainingCentreManager {



    public static int getTraineeCount(ArrayList<TrainingCentre> trainingCentre) {
        return trainingCentre.size();
    }


    public static int populateTrainingCentre(Queue<Trainee> traineeQueue, TrainingCentre trainingCentre, int uptake) {
        int resultingUptake = uptake;
        int loopMax = Math.min(uptake, trainingCentre.getRemainingCapacity());

        for (int i =0; i<loopMax; i++){
            if (traineeQueue.size() < 1) {
                return resultingUptake;
            } else {
                trainingCentre.addTrainee(traineeQueue.remove());
                resultingUptake =- 1;
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
