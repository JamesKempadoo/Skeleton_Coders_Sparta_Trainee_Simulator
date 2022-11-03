package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainingcentre.TrainingCentreManager;
import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;
import com.sparta.skeleton.model.trainingCentres.TrainingHub;
import org.junit.jupiter.api.*;

import java.util.*;

public class TrainingCentreManagerTest {


    private ArrayList<TrainingCentre> trainingCentreList = new ArrayList<>();

    private TrainingCentre trainingCentre1 = new TrainingHub();
    private TrainingCentre trainingCentre2 = new TrainingHub();
    private TrainingCentre trainingCentre3 = new TrainingHub();

    private Deque<Trainee> traineeQueue = new LinkedList<>();


    @Test
    @DisplayName("checks if it gets the trainee count")
    public void checksGetsTraineeCount(){
        trainingCentreList.add(trainingCentre1);
        trainingCentreList.add(trainingCentre2);
        trainingCentreList.add(trainingCentre3);
        Assertions.assertEquals(3, TrainingCentreManager.getTraineeCount(trainingCentreList));
    }

    @Test
    @DisplayName("populate training centre with trainees, where uptake is smaller than capacityTrainingCentre")
    public void checksPopulateTrainingCentreWhereUptakeIsSmallerThanCapacity(){
        int uptake = 25;
        //trainingCentre1;
        for (int i=0; i< 25; i++){
            traineeQueue.add(new Trainee());
        }
        Assertions.assertEquals(0, TrainingCentreManager.populateTrainingCentre(traineeQueue, trainingCentre1, uptake));
        Assertions.assertEquals(25, trainingCentre1.getCurrentCapacity());
        Assertions.assertFalse(trainingCentre1.trainingCentreIsFull());
    }


    @Test
    @DisplayName("populate training centre with trainees, where uptake is larger than capacityTrainingCentre")
    public void checksPopulateTrainingCentreWhereUptakeIsLargerThanCapacity(){
        int uptake = 50;
        //trainingCentre1;
        for (int i=0; i< 50; i++){
            traineeQueue.add(new Trainee());
        }

        for (int i =0; i<75; i++){
            trainingCentre1.addTrainee(new Trainee());
        }

        int overflowTrainingCentre1 = TrainingCentreManager.populateTrainingCentre(traineeQueue, trainingCentre1, uptake);

        Assertions.assertEquals(25, overflowTrainingCentre1);
        Assertions.assertEquals(100, trainingCentre1.getCurrentCapacity());
        Assertions.assertTrue(trainingCentre1.trainingCentreIsFull());

        Assertions.assertEquals(0, TrainingCentreManager.populateTrainingCentre(traineeQueue, trainingCentre2, overflowTrainingCentre1));
        Assertions.assertEquals(25, trainingCentre2.getCurrentCapacity());
        Assertions.assertFalse(trainingCentre2.trainingCentreIsFull());
    }

}
