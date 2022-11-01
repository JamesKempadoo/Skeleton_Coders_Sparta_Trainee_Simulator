package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;

import java.util.ArrayList;
import java.util.Queue;

public class TrainingCentreManager implements TrainingCentreManageable{


    @Override
    public int getTraineeCount(ArrayList<TrainingCentre> trainingCentre) {
        return trainingCentre.size();
    }

    @Override
    public int populateTrainingCentre(Queue<Trainee> traineeList, TrainingCentre trainingCentre, int uptake) {
        int resultingUptake;

        for (int i =0; i<uptake; i++){
            resultingUptake = uptake;
            if (traineeList.size() < 0) {
                return resultingUptake;
            } else {
                traineeList.remove();
                resultingUptake =- 1;

            }
        }

        return 0;
    }

    @Override
    public int generateRandomTraineeUptake() {
        return 0;
    }

    //USER STORIES
    //trainees populate training centre
    //Full capacity Management
    //Prioritize waiting list (? ask if its in here)




}
