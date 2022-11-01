package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;

import java.util.ArrayList;
import java.util.Queue;

public interface TrainingCentreManageable {

    //Keep count of trainees in Training Centre

    int getTraineeCount(ArrayList<TrainingCentre> trainingCentre);


    //Method for Dealing with overflow of trainees??

    int populateTrainingCentre(Queue<Trainee> traineeList, TrainingCentre trainingCentre, int uptake);

    //0-50 trainee intake

    int generateRandomTraineeUptake();




}
