package com.sparta.skeleton.controller.trainingcentre;

import com.sparta.skeleton.controller.trainee.TraineeAllocationManager;
import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;

import java.util.*;

public class TrainingCentreManager {


    public static void close(ArrayList<TrainingCentre> centres, Deque<Trainee> waitList, ArrayList<TrainingCentre> closedCentres) {
        ArrayList<TrainingCentre> centresToRemove = new ArrayList<>();
        for (TrainingCentre centre : centres) { // check each centre that needs to be closed
            if (centre.getCurrentCapacity() < 25 && centre.isOverMaxMonths()) {
                closeCentre(centre, waitList, closedCentres);
                centresToRemove.add(centre);
            }
        }
        centres.removeAll(centresToRemove);
    }

    public static void closeCentre(TrainingCentre centre, Deque<Trainee> waitList, ArrayList<TrainingCentre> closedCentres) {
        TraineeAllocationManager.sendToFrontOfWaitList(centre, waitList);
        closedCentres.add(centre);
    }


    public static int getTraineeCount(ArrayList<TrainingCentre> trainingCentre) {
        return trainingCentre.size();
    }


    public static int populateTrainingCentre(Deque<Trainee> traineeQueue, TrainingCentre trainingCentre, int uptake) {
        ArrayList<Trainee> notMatchingCourseType = new ArrayList<>();
        while (uptake > 0 && !trainingCentre.trainingCentreIsFull() && !traineeQueue.isEmpty()) {
            if (Arrays.stream(trainingCentre.getCourseTypes()).anyMatch(s -> {
                assert traineeQueue.peek() != null;
                return s.equals(traineeQueue.peek().getCourseType());
            })) {
                trainingCentre.addTrainee(traineeQueue.remove());
                uptake--;
            } else {
                notMatchingCourseType.add(traineeQueue.remove());
            }
        }
        for (Trainee trainee : notMatchingCourseType) {
            traineeQueue.addFirst(trainee);
        }
        return uptake;
    }

    public static int generateRandomTraineeUptake() {
        Random random = new Random();

        return random.nextInt(51);
    }

    public static void incrementMonthCounter(ArrayList<TrainingCentre> trainingCentres) {
        for (TrainingCentre centre : trainingCentres) {
            centre.incrementMonth();
        }
    }

}
