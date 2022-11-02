package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.model.TrainingCentres.Bootcamp;
import com.sparta.skeleton.model.TrainingCentres.TechCentre;
import com.sparta.skeleton.model.TrainingCentres.TrainingCentre;
import com.sparta.skeleton.model.TrainingCentres.TrainingHub;

import java.util.Random;

public class TrainingCentreGenerator {

    public static final int BOOTCAMPS_MAX = 2;

    public static int bootcampCount = 0;

    //Call Training Centre object and create new
    //To String method


    //USER STORIES
    //Generation for training Centre


    public static TrainingCentre generateTrainingCentre() throws RuntimeException {
        Random rand = new Random();
        int nextCenter;

        if (bootcampCount >= BOOTCAMPS_MAX) {
            nextCenter = rand.nextInt(2);
        } else {
            nextCenter = rand.nextInt(3);
        }

        switch (nextCenter) {
            case 0:
                return new TrainingHub();
            case 1:
                return new TechCentre();
            case 2:
                bootcampCount++;
                return new Bootcamp();
            default:
                throw new RuntimeException("Invalid case");
        }

    }
}
