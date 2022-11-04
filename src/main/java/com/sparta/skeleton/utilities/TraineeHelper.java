package com.sparta.skeleton.utilities;

import java.util.ArrayList;
import java.util.Random;

public class TraineeHelper {

    public static final String[] TRAINEE_TYPES = {"Java", "C#", "Data", "DevOps", "Business"};

    public static String[] getRandomTraineeTypes(int size) {
        Random rnd = new Random();
        ArrayList<String> randomTypes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomTypes.add(TRAINEE_TYPES[rnd.nextInt(0,TRAINEE_TYPES.length)]);
        }
        return randomTypes.toArray(new String[0]);

    }
}
