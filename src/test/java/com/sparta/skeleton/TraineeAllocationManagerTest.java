package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainee.TraineeAllocationManager;
import com.sparta.skeleton.controller.trainee.TraineeGenerator;
import com.sparta.skeleton.model.trainees.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeAllocationManagerTest {

    @Test
    @DisplayName("Check that merging trainee queues, fills first queue and empties the second")
    void checkTraineeQueuesMerged() {
        long seed = System.currentTimeMillis();
        Queue<Trainee> first = TraineeGenerator.generateTrainees(TraineeGenerator.getRandomTraineesCount(seed));
        Queue<Trainee> second = TraineeGenerator.generateTrainees(TraineeGenerator.getRandomTraineesCount(seed));

        Queue<Trainee> firstCopy = new LinkedList<>(first);
        Queue<Trainee> secondCopy = new LinkedList<>(second);

        secondCopy.addAll(firstCopy);
        firstCopy.clear();

        TraineeAllocationManager.mergeQueues(first, second);

        Assertions.assertEquals(secondCopy, secondCopy);
    }



}
