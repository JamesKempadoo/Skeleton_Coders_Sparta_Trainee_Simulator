package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainee.TraineeGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TraineeGeneratorTest {


    // getRandomTraineesCount returns random integer between 0-100

    @Test
    @DisplayName("Check that seed input returns pseudo-random integer in range of 0-100")
    public void checkThatRandomGeneratorReturns0To100() {
        long seed = System.currentTimeMillis();
        TraineeGenerator gen = new TraineeGenerator();

        int max = 100;
        int min = 0;
        int randCount = gen.getRandomTraineesCount(seed);
        Assertions.assertTrue(randCount <= max && randCount >= min, randCount + " is NOT within " + max + " and " + min);
    }

    @Test
    @DisplayName("Check that seed input returns pseudo-random random integer")
    public void checkThatRandomGeneratorReturnsRandomInt() {
        long seed = System.currentTimeMillis();
        TraineeGenerator gen = new TraineeGenerator();
        Random rand = new Random(seed);

        Assertions.assertEquals(rand.nextInt(100 + 1), gen.getRandomTraineesCount(seed));
    }


}
