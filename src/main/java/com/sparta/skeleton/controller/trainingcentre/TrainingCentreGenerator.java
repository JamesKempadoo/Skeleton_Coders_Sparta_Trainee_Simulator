package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.model.TrainingCentres.Bootcamp;
import com.sparta.skeleton.model.TrainingCentres.TechCentre;
import com.sparta.skeleton.model.TrainingCentres.TrainingCentre;
import com.sparta.skeleton.model.TrainingCentres.TrainingHub;

import java.util.ArrayList;
import java.util.Random;

public class TrainingCentreGenerator {

    public static final int BOOTCAMP_MAX = 2;

    //Call Training Centre object and create new
    //To String method


    //USER STORIES
    //Generation for training Centre


    public static void generateTrainingCentre(ArrayList<TrainingCentre> trainingCentres) throws RuntimeException {
        Random rand = new Random();
        int nextCenter;

        if (trainingCentres.stream().filter(trainingCentre -> trainingCentre.getClass().getSimpleName().equals("Bootcamp")).count() >= BOOTCAMP_MAX) {
            nextCenter = rand.nextInt(2);
        } else {
            nextCenter = rand.nextInt(3);
        }

        switch (nextCenter) {
            case 0:
                for (int i = 0; i < 3; i++) {
                    trainingCentres.add(new TrainingHub());
                }
                break;
            case 1:
                trainingCentres.add(new TechCentre());
                break;
            case 2:
                trainingCentres.add(new Bootcamp());
                break;
            default:
                throw new RuntimeException("Invalid case");
        }
    }
}
