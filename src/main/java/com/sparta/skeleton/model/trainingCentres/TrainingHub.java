package com.sparta.skeleton.model.trainingCentres;

import com.sparta.skeleton.utilities.TraineeHelper;

public class TrainingHub extends TrainingCentre {
    //Can train a max of 100 trainees
    //3 can be opened at a time every 2 months

    public TrainingHub() {
        super();
        setCourseType(TraineeHelper.TRAINEE_TYPES);
    }

    @Override
    public int getMaxMonths() {
        return 1;
    }

    @Override
    public int getMaxCapacity() {
        return 100;
    }
}
