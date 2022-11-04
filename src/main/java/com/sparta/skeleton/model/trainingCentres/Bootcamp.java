package com.sparta.skeleton.model.trainingCentres;

import com.sparta.skeleton.utilities.TraineeHelper;

public class Bootcamp extends TrainingCentre{
    //Can train a max of 500 trainees
    //Can stay open for 3 months with less than 25 people
    //Close after 3 months if it still has less than 25 people
    //Only 2 can exist at a time


    public Bootcamp() {
        super();
        setCourseType(TraineeHelper.TRAINEE_TYPES);
    }


    @Override
    public int getMaxMonths() {
        return 3;
    }

    @Override
    public int getMaxCapacity() {
        return 500;
    }
}
