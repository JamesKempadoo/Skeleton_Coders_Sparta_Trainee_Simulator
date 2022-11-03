package com.sparta.skeleton.utilities;

import java.util.Random;

public class TraineeHelper {

    public static final String[] TRAINEE_TYPES = {"Java", "C#", "Data", "DevOps", "Business"};

    public static String getRandomTraineeType() {
        Random rnd = new Random();
        return TRAINEE_TYPES[rnd.nextInt(0,TRAINEE_TYPES.length)];

    }
}
