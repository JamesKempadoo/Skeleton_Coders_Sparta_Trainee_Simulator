package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.model.TrainingCentres.Bootcamp;
import com.sparta.skeleton.model.TrainingCentres.TechCentre;
import com.sparta.skeleton.model.TrainingCentres.TrainingCentre;
import com.sparta.skeleton.model.TrainingCentres.TrainingHub;

import java.util.Random;

public class TrainingCentreGenerator {


    //Call Training Centre object and create new
    //To String method


    //USER STORIES
    //Generation for training Centre


    public static TrainingCentre generateTrainingCentre() throws RuntimeException {
        Random rand = new Random();

        return switch (rand.nextInt(3)) {
            case 0 -> new Bootcamp();
            case 1 -> new TechCentre();
            case 2 -> new TrainingHub();
            default -> throw new RuntimeException("Invalid case");
        };

    }
}
