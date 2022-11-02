package com.sparta.skeleton.model.TrainingCentres;

public class TrainingHub extends TrainingCentre {
    //Can train a max of 100 trainees
    //3 can be opened at a time every 2 months
    private final int maxCapacity = 0;

    public TrainingHub() {
        super(100, 1);
    }
}
