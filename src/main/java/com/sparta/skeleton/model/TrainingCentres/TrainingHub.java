package com.sparta.skeleton.model.TrainingCentres;

public class TrainingHub extends TrainingCentre {
    //Can train a max of 100 trainees
    //3 can be opened at a time every 2 months

    public TrainingHub() {
        super(100, 1);
        setCourseType(new String[]{"Java", "C#", "Data", "DevOps", "Business"});
    }
}
