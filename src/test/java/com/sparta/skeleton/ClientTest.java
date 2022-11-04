package com.sparta.skeleton;

import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.model.trainees.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
public class ClientTest {

    private static final Client c1 = new Client();
    private static final Client c2 = new Client();
    private static final Client c3 = new Client();
    private static final Client c4 = new Client();

    @Test
    @DisplayName("Test that number of months is 0")
    void testThatNumberOfMonthsIs0() {
        Assertions.assertEquals(0, c1.getCountMonths());
    }

    @Test
    @DisplayName("Test that number of months is 1")
    void testThatNumberOfMonthsIs1() {
        c1.incrementMonth();
        Assertions.assertEquals(1, c1.getCountMonths());
    }

    @Test
    @DisplayName("Test that trainee requirement is > 15")
    void testThatTraineeRequirementIsGreater15() {
        Assertions.assertTrue(c1.getTraineeRequirement()>15);
    }

    @Test
    @DisplayName("Test that a client is created with a correct course type")
    void testThatAClientIsCreatedWithACorrectCourseType() {
        String[] courses = {"Java", "C#", "Data", "DevOps", "Business"};
        String[] course = c1.getRequiredTraineeType();
        Assertions.assertTrue(Arrays.asList(courses).containsAll(Arrays.asList(course)));
    }

    @Test
    @DisplayName("check if trainee is added to Client")
    public void checkIfTraineeIsAddedToClient() {
        Trainee t = new Trainee();
        c1.addTrainee(t);
        Assertions.assertEquals(t,c1.getTraineeList().get(0));
    }

    @Test
    @DisplayName("check if trainee does not added to training centre when full")
    public void checkIfTraineeDoesNotAddedToTrainingCentreWhenFull() {
        for (int i = 0; i < c1.getTraineeRequirement()+1; i++){
            Trainee trainee = new Trainee();
            c1.addTrainee(trainee);
        }
        Assertions.assertEquals(c1.getTraineeRequirement(),c1.getTraineeList().size());
    }



    @Test
    @DisplayName("Test that client is happy if requirement is greater trainee requirements and month is greater than 12 ")
    public void testThatClientIsHappyIfRequirementIsGreaterTraineeRequirementsAndMonthIsGreaterThan12() {
        for (int i = 0; i < 13; i++){
            c2.incrementMonth();
        }
        for (int i = 0; i < c2.getTraineeRequirement()+1; i++){
            Trainee t = new Trainee();
            c2.addTrainee(t);
        }
        Assertions.assertTrue(c2.isHappy());
    }

    @Test
    @DisplayName("Test that client is not happy if requirement is lower than trainee requirements and month is greater than 12 ")
    public void testThatClientIsNotHappyIfRequirementLowerThanTraineeRequirementsAndMonthIsGreaterThan12() {
        for (int i = 0; i < 12; i++) {
            Trainee t = new Trainee();
            c3.incrementMonth();
        }
        Assertions.assertFalse(c3.isHappy());
    }
}
