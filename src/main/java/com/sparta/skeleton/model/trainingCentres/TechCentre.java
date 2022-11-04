package com.sparta.skeleton.model.trainingCentres;

import com.sparta.skeleton.utilities.TraineeHelper;

public class TechCentre extends TrainingCentre {
    //Can train max of 200 trainees
    //Only teaches ONE course per centre
    //Course type for centre is chosen randomly when opened

    public TechCentre() {
        super();
        setCourseType(TraineeHelper.getRandomTraineeTypes(1));
    }

    @Override
    public int getMaxMonths() {
        return 1;
    }

    @Override
    public int getMaxCapacity() {
        return 200;
    }
}
