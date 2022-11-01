package com.sparta.skeleton;

import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainingCentreTest {
    private static TrainingCentre trainingCentre1 = new TrainingCentre();
    private static TrainingCentre trainingCentre2 = new TrainingCentre();
    private static TrainingCentre trainingCentre3 = new TrainingCentre();

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
        Assertions.assertEquals(false,trainingCentre1.trainingCentreIsFull());
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
    @DisplayName("check capacity of training centre is 100")
    public void checkCapacityOfTrainingCentreIs100() {
        for (int i = 0; i < 101; i++){
            Trainee trainee = new Trainee();
            trainingCentre3.addTrainee(trainee);
        }
        Assertions.assertEquals(100,trainingCentre3.getCurrentCapacity());
    }

    @Test
    @DisplayName("check training centre is full is True")
    public void checkTrainingCentreIsFullIsTrue() {
        Assertions.assertEquals(true,trainingCentre3.trainingCentreIsFull());
    }

    @Test
    @DisplayName("check training centre id increment when making new training centre")
    public void checkTrainingCentreIdIncrementWhenMakingNewTrainingCentre() {
        Assertions.assertEquals(1,trainingCentre1.getTrainingCentreID());
        Assertions.assertEquals(2,trainingCentre2.getTrainingCentreID());
    }


}
