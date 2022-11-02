package com.sparta.skeleton.model.TrainingCentres;

public class TechCentre extends TrainingCentre {
    //Can train max of 200 trainees
    //Only teaches ONE course per centre
    //Course type for centre is chosen randomly when opened

    private final int maxCapacity = 200;

    public TechCentre() {
        super(200, 1);
    }
}
