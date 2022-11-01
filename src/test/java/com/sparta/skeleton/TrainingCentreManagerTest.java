package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainingcentre.TrainingCentreManager;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrainingCentreManagerTest {


    private ArrayList<TrainingCentre> trainingCentreList = new ArrayList<>();

    private TrainingCentre trainingCentre1 = new TrainingCentre();
    private TrainingCentre trainingCentre2 = new TrainingCentre();
    private TrainingCentre trainingCentre3 = new TrainingCentre();

    private Queue<Trainee> traineeQueue = new LinkedList<>();


    @Test
    @DisplayName("checks if it gets the trainee count")
    public void checksGetsTraineeCount(){
        trainingCentreList.add(trainingCentre1);
        trainingCentreList.add(trainingCentre2);
        trainingCentreList.add(trainingCentre3);
        Assertions.assertEquals(3, TrainingCentreManager.getTraineeCount(trainingCentreList));
    }

//    @Test
//    @DisplayName("populate training centre with trainees, where uptake is smaller than capacityTrainingCentre")
//    public void checksPopulateTrainingCentreWhereUptakeIsSmallerThanCapacity(){
//        int uptake = 25;
//        //trainingCentre1;
//        for (int i=0; i< 25; i++){
//            traineeQueue.add(new Trainee());
//        }
//        Assertions.assertEquals(0, TrainingCentreManager.populateTrainingCentre(traineeQueue, trainingCentre1, uptake));
//        Assertions.assertEquals(25, trainingCentre1.getCurrentCapacity());
//        Assertions.assertEquals(false, trainingCentre1.trainingCentreIsFull());
//    }

//    @Test
//    @DisplayName("populate training centre with trainees, where uptake is larger than capacityTrainingCentre")
//    public void checksPopulateTrainingCentreWhereUptakeIsLargerThanCapacity(){
//
//        Assertions.assertEquals(3, TrainingCentreManager.getTraineeCount(trainingCentreList));
//    }
}
