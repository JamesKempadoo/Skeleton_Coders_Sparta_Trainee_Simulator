package com.sparta.skeleton.utilities;

import java.util.Random;

public class NonGaussianRandomBias {

    public static int randomBiasGenerator() {
        Random rnd = new Random();
        double num = rnd.nextDouble();

        if (num < 0.8){ // 80% chance
            return rnd.nextInt(15, 50);
        } else if (num < 0.9) { // 10% chance
            return rnd.nextInt(50, 100);
        } else if (num < 0.97) { // 7% chance
            return  rnd.nextInt(100, 300);
        } else if (num < 0.995) { // 2.5% chance
            return  rnd.nextInt(300, 1000);
        } else { // 0.5% chance
            return Math.abs(rnd.nextInt());
        }
    }
}
