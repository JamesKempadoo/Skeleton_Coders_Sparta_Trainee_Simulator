package com.sparta.skeleton.controller.trainee;

import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;

import java.util.ArrayList;

public class TraineeManager {

    public static void incrementTraineeMonthCounter(ArrayList<TrainingCentre> trainingCentres) {
        for (TrainingCentre centre : trainingCentres) {
            for (Trainee trainee :centre.getTraineeList()) {
                trainee.incrementMonthsTrained();
            }
        }
    }
}
