package com.sparta.skeleton;

import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.model.trainingCentres.Bootcamp;
import com.sparta.skeleton.model.trainingCentres.TechCentre;
import com.sparta.skeleton.model.trainingCentres.TrainingHub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

public class TrainingCentreTest {
    private static final TrainingHub trainingHubTest1 = new TrainingHub();
    private static final TrainingHub trainingHubTest2 = new TrainingHub();
    private static final TrainingHub trainingHubTest3 = new TrainingHub();
    private static final TechCentre techCentreTest1 = new TechCentre();
    private static final TechCentre techCentreTest2 = new TechCentre();
    private static final Bootcamp bootcampTest1 = new Bootcamp();
    private static final Bootcamp bootcampTest2 = new Bootcamp();

    //Training Hub Tests ++++++++++++++++++++++++++++++++++++++

    @Test
    @DisplayName("check capacity of Training Hub is 0 when created")
    public void checkCapacityOfTrainingHubIs0() {
        Assertions.assertEquals(0, trainingHubTest1.getCurrentCapacity());
    }

    @Test
    @DisplayName("check Training Hub is full is false")
    public void checkTrainingHubIsFullIsFalse() {
        Assertions.assertFalse(trainingHubTest1.trainingCentreIsFull());
    }

    @Test
    @DisplayName("check if trainee is added to Training Hub")
    public void checkIfTraineeIsAddedToTrainingHub() {
        Trainee trainee = new Trainee();
        trainingHubTest2.addTrainee(trainee);
        Assertions.assertEquals(1, trainingHubTest2.getTraineesList().size());
    }

    @Test
    @DisplayName("check if trainee is not added to Training Hub when full")
    public void checkIfTraineeIsNotAddedToTrainingHubWhenFull() {
        for (int i = 0; i < 101; i++){
            Trainee trainee = new Trainee();
            trainingHubTest3.addTrainee(trainee);
        }
        Assertions.assertEquals(100, trainingHubTest3.getTraineesList().size());
    }

    @Test
    @DisplayName("check capacity of training Hub is 100 and training centre is full is True")
    public void checkCapacityOfTrainingHubIs100() {
        for (int i = 0; i < 101; i++){
            Trainee trainee = new Trainee();
            trainingHubTest3.addTrainee(trainee);
        }
        Assertions.assertEquals(100, trainingHubTest3.getCurrentCapacity());
        Assertions.assertTrue(trainingHubTest3.trainingCentreIsFull());
    }


    @Test
    @DisplayName("check training Hub remaining capacity")
    public void checkTrainingHubRemainingCapacity() {
        TrainingHub trainingHub4 = new TrainingHub();
        for (int i = 0; i < 99; i++){
            Trainee trainee = new Trainee();
            trainingHub4.addTrainee(trainee);
        }
        Assertions.assertEquals(1,trainingHub4.getRemainingCapacity());
    }

    @Test
    @DisplayName("Test that a valid course type is set to a Training Hub")
    public void testThatAValidCourseTypeIsSetToAHub() {
        String[] courses = {"Java", "C#", "Data", "DevOps", "Business"};
        trainingHubTest1.setCourseType(courses);
        Assertions.assertArrayEquals(courses, trainingHubTest1.getCourseTypes());
    }

    //Bootcamp Tests ++++++++++++++++++++++++++++++++++++++

    @Test
    @DisplayName("check capacity of Bootcamp is 0 when created")
    public void checkCapacityOfBootcampIs0() {
        Assertions.assertEquals(0, bootcampTest1.getCurrentCapacity());
    }

    @Test
    @DisplayName("check Bootcamp is full is false")
    public void checkBootcampIsFullIsFalse() {
        Bootcamp bootcampTest3 = new Bootcamp();
        Assertions.assertFalse(bootcampTest3.trainingCentreIsFull());
    }

    @Test
    @DisplayName("check capacity of Bootcamp is 500 and Bootcamp is full is True")
    public void checkCapacityOfBootcampIs500() {
        for (int i = 0; i < 501; i++){
            Trainee trainee = new Trainee();
            bootcampTest1.addTrainee(trainee);
        }
        Assertions.assertEquals(500, bootcampTest1.getCurrentCapacity());
        Assertions.assertTrue(bootcampTest1.trainingCentreIsFull());
    }

    @Test
    @DisplayName("check if trainee is not added to Bootcamp when full")
    public void checkIfTraineeIsNotAddedToBootcampWhenFull() {
        for (int i = 0; i < 501; i++){
            Trainee trainee = new Trainee();
            bootcampTest2.addTrainee(trainee);
        }
        Assertions.assertEquals(500, bootcampTest2.getTraineesList().size());
        Trainee trainee = new Trainee();
        bootcampTest2.addTrainee(trainee);
        Assertions.assertEquals(500, bootcampTest2.getTraineesList().size());
    }



    //Tech Centre Tests ++++++++++++++++++++++++++++++++++++++


    @Test
    @DisplayName("check capacity of Tech Centre is 0 when created")
    public void checkCapacityOfTechCentreIs0() {
        Assertions.assertEquals(0, techCentreTest1.getCurrentCapacity());
    }

    @Test
    @DisplayName("check Tech Centre is full is false")
    public void checkTechCentreIsFullIsFalse() {
        TechCentre techCentreTest3 = new TechCentre();
        Assertions.assertFalse(techCentreTest3.trainingCentreIsFull());
    }

    @Test
    @DisplayName("check capacity of Tech Centre is 200 and Tech Centre is full is True and type is matched")
    public void checkCapacityOfTechCentreIs200AndTypeIsMatched() {
        int i = 0;
        while (i < 201){
            Trainee trainee = new Trainee();
            if ((Arrays.stream(techCentreTest1.getCourseTypes()).anyMatch(s -> Objects.equals(s, trainee.getCourseType())))){
                i++;
                techCentreTest1.addTrainee(trainee);
            }
        }
        Assertions.assertEquals(200, techCentreTest1.getCurrentCapacity());
        Assertions.assertTrue(techCentreTest1.trainingCentreIsFull());
    }

    @Test
    @DisplayName("check if trainee is not added to Tech Centre when full")
    public void checkIfTraineeIsNotAddedToTechCentreWhenFull() {
        int i = 0;
        while (i < 201){
            Trainee trainee = new Trainee();
            if ((Arrays.stream(techCentreTest2.getCourseTypes()).anyMatch(s -> Objects.equals(s, trainee.getCourseType())))){
                i++;
                techCentreTest2.addTrainee(trainee);
            }
        }
        Assertions.assertEquals(200, techCentreTest2.getTraineesList().size());

        while (i < 202){
            Trainee trainee = new Trainee();
            if ((Arrays.stream(techCentreTest2.getCourseTypes()).anyMatch(s -> Objects.equals(s, trainee.getCourseType())))){
                i++;
                techCentreTest2.addTrainee(trainee);
            }
        }
        Assertions.assertEquals(200, techCentreTest2.getTraineesList().size());
    }
}
