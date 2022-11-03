package com.sparta.skeleton.controller.trainee;


import com.sparta.skeleton.model.trainees.Trainee;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TraineeGenerator {

    static final int TRAINEEMAX = 100;
    static final int TRAINEEMIN = 0;

    static public Queue<Trainee> getTrainees() {
        long seed = System.currentTimeMillis();
        return generateTrainees(getRandomTraineesCount(seed));
    }

    static public int getRandomTraineesCount(long seed) {
        Random randomizer = new Random(seed);
        return randomizer.nextInt(TRAINEEMAX - TRAINEEMIN + 1) + TRAINEEMIN;
    }

    static public Queue<Trainee> generateTrainees(int count) {
        Queue<Trainee> trainees = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            trainees.add(new Trainee());
        }

        return trainees;
    }
}
