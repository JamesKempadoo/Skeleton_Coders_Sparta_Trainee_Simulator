package com.sparta.skeleton;

import com.sparta.skeleton.utilities.NonGaussianRandomBias;
import org.junit.jupiter.api.Test;

public class NonGaussianRandomBiasTest {

    @Test
    void display100RandomNumbers(){

        for (int i = 0; i<101 ; i++)
            System.out.println(NonGaussianRandomBias.randomBiasGenerator());
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
            int tempInt = NonGaussianRandomBias.randomBiasGenerator();
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
