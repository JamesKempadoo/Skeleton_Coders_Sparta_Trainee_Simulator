package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;

import java.util.ArrayList;

public interface TrainingCentreManageable {

    //Keep count of trainees in Training Centre

    int getTraineeCount();


    //Method for Dealing with overflow of trainees??

    void traineeOverflowHandler();
    // calls TraineeAllocationManager

    //check if full
    boolean isFull(TrainingCentre trainingcentre);


    void populateTrainingCentre(ArrayList<Trainee> traineeList);

    //0-50 trainee intake

    int generateRandomTraineeUptake();

}
