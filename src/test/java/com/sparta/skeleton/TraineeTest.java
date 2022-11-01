package com.sparta.skeleton;

import com.sparta.skeleton.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TraineeTest {

    @Test
    @DisplayName("Test that the first Trainee created has a traineeID of 1")
    void testFirstTraineeCreated() {
        Trainee trainee = new Trainee();
        Assertions.assertEquals(trainee.getTraineeID(), 1);
    }

    @Test
    @DisplayName("Test that the second Trainee created has a traineeID of 2")
    void testSecondTraineeCreated() {
        Trainee trainee = new Trainee();
        Assertions.assertEquals(trainee.getTraineeID(), 2);
    }
}