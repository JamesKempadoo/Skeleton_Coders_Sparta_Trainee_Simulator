package com.sparta.skeleton.model.TrainingCentres;

public class Bootcamp extends TrainingCentre{
    //Can train a max of 500 trainees
    //Can stay open for 3 months with less than 25 people
    //Close after 3 months if it still has less than 25 people
    //Only 2 can exist at a time


    public Bootcamp() {
        super(500, 3);
        setCourseType(new String[] {"Java", "C#", "Data", "DevOps", "Business"});
    }


}
