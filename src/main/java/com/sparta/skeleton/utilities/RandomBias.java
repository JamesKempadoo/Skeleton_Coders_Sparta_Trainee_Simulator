package com.sparta.skeleton.utilities;

import java.util.Random;

public class RandomBias {

    public static int randomBiasGenerator() {
        Random randomDouble = new Random();
        Random randomInt = new Random();
        double num = randomDouble.nextDouble();

        System.out.println("Random double generated: " + num);

        if (num < 0.8){
            return randomInt.nextInt(15, 50);
        } else if (num < 0.9) {
            return randomInt.nextInt(50, 100);
        } else if (num < 0.97) {
            return  randomInt.nextInt(100, 300);
        } else if (num < 0.995) {
            return  randomInt.nextInt(300, 1000);
        } else {
            return Math.abs(randomInt.nextInt());
        }
    }
}
