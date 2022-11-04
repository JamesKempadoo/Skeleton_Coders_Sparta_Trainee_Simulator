package com.sparta.skeleton;

import com.sparta.skeleton.model.trainees.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TraineeTest {

    private static Trainee trainee = new Trainee();
    private static Trainee trainee2 = new Trainee();

    @Test
    @DisplayName("Test that a trainee is created with a correct course type")
    void testThatATraineeIsCreatedWithACorrectCourseType() {
        String[] courses = {"Java", "C#", "Data", "DevOps", "Business"};
        String course = trainee.getCourseType();
        Assertions.assertTrue(Arrays.asList(courses).contains(course));
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

