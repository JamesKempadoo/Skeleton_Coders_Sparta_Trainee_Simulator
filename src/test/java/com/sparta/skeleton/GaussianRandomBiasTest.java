package com.sparta.skeleton;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class GaussianRandomBiasTest {

    private int setTraineeRequirement() {
        Random rng = new Random();
        int delay;
        do {
            double val = rng.nextGaussian() * 10 + 15;
            delay = (int) Math.round(val);
        } while (delay <= 15);
        return delay;
    }

    @Test
    void display100RandomNumbers(){

        for (int i = 0; i<101 ; i++)
            System.out.println(setTraineeRequirement());
    }

    @Test
    void summaryOf1000000RandomNumbers(){
        int between15And50 = 0;
        int between50And100 = 0;
        int between100And300 = 0;
        int between300And1000 = 0;
        int over1000 = 0;
        final double MILL = 1000000;

        for (int i = 0; i<1000001 ; i++){
            int tempInt = setTraineeRequirement();
            if (tempInt < 50)  {
                between15And50++;
            } else if (tempInt < 100) {
                between50And100++;
            } else if (tempInt < 300){
                between100And300++;
            } else if (tempInt < 1000) {
                between300And1000++;
            } else {
                over1000++;
            }
        }

        System.out.println("Between 15 and 50: " + between15And50 + " -> " + (between15And50/MILL)*100 + "%");
        System.out.println("Between 50 and 100: " + between50And100 + " -> " + (between50And100/MILL)*100 + "%");
        System.out.println("Between 100 and 300: " + between100And300 + " -> " + (between100And300/MILL)*100 + "%");
        System.out.println("Between 300 and 1000: " + between300And1000 + " -> " + (between300And1000/MILL)*100 + "%");
        System.out.println("Over 1000: " + over1000 + " -> " + (over1000/MILL)*100 + "%");
    }
}
