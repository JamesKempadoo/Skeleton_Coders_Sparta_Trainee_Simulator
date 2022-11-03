package com.sparta.skeleton.model.trainingCentres;

import java.util.Random;

public class TechCentre extends TrainingCentre {
    //Can train max of 200 trainees
    //Only teaches ONE course per centre
    //Course type for centre is chosen randomly when opened

    public TechCentre() {
        super(200, 1);
        String[] courses = {"Java", "C#", "Data", "DevOps", "Business"};
        Random rng = new Random();
        setCourseType(new String[] {courses[rng.nextInt(courses.length)]});
    }
}
