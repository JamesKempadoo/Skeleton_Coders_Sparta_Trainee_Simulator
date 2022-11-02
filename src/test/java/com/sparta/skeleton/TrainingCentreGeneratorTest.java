package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainingcentre.TrainingCentreGenerator;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainingCentreGeneratorTest {

    @Test
    @DisplayName("Test that the first TrainingCentre")
    void testFirstTraineeCreated() {
        TrainingCentre trainingCentre1 = new TrainingCentre();
        Assertions.assertEquals(trainingCentre1.getClass(), TrainingCentreGenerator.generateTrainingCentre().getClass());
    }
    

}
