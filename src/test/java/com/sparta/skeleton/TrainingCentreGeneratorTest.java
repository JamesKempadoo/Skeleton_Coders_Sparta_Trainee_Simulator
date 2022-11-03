package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainingcentre.TrainingCentreGenerator;
import com.sparta.skeleton.model.TrainingCentres.Bootcamp;
import com.sparta.skeleton.model.TrainingCentres.TrainingCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TrainingCentreGeneratorTest {

    @Test
    @DisplayName("Test that the first TrainingCentre")
    void testFirstTraineeCreated() {
        ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();
        TrainingCentreGenerator.generateTrainingCentre(trainingCentres);
        TrainingCentre trainingCentre1 = new Bootcamp();
        Assertions.assertEquals(trainingCentre1.getClass().getSuperclass(), trainingCentres.get(0).getClass().getSuperclass());
    }
    

}
