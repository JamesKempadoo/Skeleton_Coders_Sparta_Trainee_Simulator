package com.sparta.skeleton;

import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;
import com.sparta.skeleton.model.trainingCentres.TrainingHub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TrainingCentreTest {
    private static TrainingCentre trainingCentre1 = new TrainingHub();
    private static TrainingCentre trainingCentre2 = new TrainingHub();
    private static TrainingCentre trainingCentre3 = new TrainingHub();

    @Test
    @DisplayName("check first new training centre get id returns 1")
    public void checkFirstNewTrainingCentreGetIdReturns1() {
        Assertions.assertEquals(1,trainingCentre1.getTrainingCentreID());
    }
    @Test
    @DisplayName("check capacity of training centre is 0")
    public void checkCapacityOfTrainingCentreIs0() {
        Assertions.assertEquals(0,trainingCentre1.getCurrentCapacity());
    }

    @Test
    @DisplayName("check training centre is full is false")
    public void checkTrainingCentreIsFullIsFalse() {
        Assertions.assertFalse(trainingCentre1.trainingCentreIsFull());
    }

    @Test
    @DisplayName("check if trainee is added to training centre")
    public void checkIfTraineeIsAddedToTrainingCentre() {
        Trainee trainee = new Trainee();
        trainingCentre2.addTrainee(trainee);
        Assertions.assertEquals(1,trainingCentre2.getTraineeList().size());
    }

    @Test
    @DisplayName("check if trainee does not added to training centre when full")
    public void checkIfTraineeDoesNotAddedToTrainingCentreWhenFull() {
        for (int i = 0; i < 101; i++){
            Trainee trainee = new Trainee();
            trainingCentre3.addTrainee(trainee);
        }
        Assertions.assertEquals(100,trainingCentre3.getTraineeList().size());
    }

    @Test
    @DisplayName("check capacity of training centre is 100 and training centre is full is True")
    public void checkCapacityOfTrainingCentreIs100() {
        for (int i = 0; i < 101; i++){
            Trainee trainee = new Trainee();
            trainingCentre3.addTrainee(trainee);
        }
        Assertions.assertEquals(100,trainingCentre3.getCurrentCapacity());
        Assertions.assertTrue(trainingCentre3.trainingCentreIsFull());
    }

    @Test
    @DisplayName("check training centre id increment when making new training centre")
    public void checkTrainingCentreIdIncrementWhenMakingNewTrainingCentre() {
        Assertions.assertEquals(1,trainingCentre1.getTrainingCentreID());
        Assertions.assertEquals(2,trainingCentre2.getTrainingCentreID());
    }

    @Test
    @DisplayName("check training centre remaining capacity")
    public void checkTrainingCentreRemainingCapacity() {
        TrainingCentre trainingCentre4 = new TrainingHub();
        for (int i = 0; i < 99; i++){
            Trainee trainee = new Trainee();
            trainingCentre4.addTrainee(trainee);
        }
        Assertions.assertEquals(1,trainingCentre4.getRemainingCapacity());
    }

    @Test
    @DisplayName("Test that a valid course type is set to a Training Centre")
    public void testThatAValidCourseTypeIsSetToATrainingCentre() {
        String[] courses = {"Java", "C#", "Data", "DevOps", "Business"};
        trainingCentre1.setCourseType(courses);
        Assertions.assertArrayEquals(courses, trainingCentre1.getCourseTypes());
    }
}
