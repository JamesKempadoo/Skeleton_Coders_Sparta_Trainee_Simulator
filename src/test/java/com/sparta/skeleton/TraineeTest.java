package com.sparta.skeleton;

import com.sparta.skeleton.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

import java.util.Arrays;

public class TraineeTest {

    private static Trainee trainee = new Trainee();
    private static Trainee trainee2 = new Trainee();

    @Test
    @DisplayName("Test that the first Trainee created has a traineeID of 1")
    void testFirstTraineeCreated() {
        Assertions.assertEquals(1,trainee.getTraineeID());
    }


    @Test
    @DisplayName("Test that a trainee is created with a correct course type")
    void testThatATraineeIsCreatedWithACorrectCourseType() {
        String[] courses = {"Java", "C#", "Data", "DevOps", "Business"};
        String course = trainee.getCourseType();
        Assertions.assertTrue(Arrays.asList(courses).contains(course));
    }

    @Test
    @DisplayName("Test that the second Trainee created has a traineeID of 2")
    void testSecondTraineeCreated() {
        Assertions.assertEquals(2, trainee2.getTraineeID());
    }

    @Test
    @DisplayName("Test that months trained is updated when using increment method")
    void testThatMonthsTrainedIsUpdatedWhenUsingIncrementMethod(){
        for(int i = 0; i < 5; i++) {
            trainee.incrementMonthsTrained();
        }
        Assertions.assertEquals(5, trainee.getMonthsTrained());
    }


}

