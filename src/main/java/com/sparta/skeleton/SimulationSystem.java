package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainee.TraineeAllocationManager;
import com.sparta.skeleton.controller.trainee.TraineeGenerator;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreGenerator;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentres.TrainingCentre;
import com.sparta.skeleton.util.log.LoggerSingleton;
import com.sparta.skeleton.view.DisplayManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimulationSystem {

    static Logger logger = LoggerSingleton.getSingleton().getLogger();
    private final Queue<Trainee> waitingList = new LinkedList<>();

    private Queue<Trainee> traineesInWild = new LinkedList<>();

    private final ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();

    public void runSimulation(int years, boolean isOutputAnnual) {
        int durationInMonths = years * 12;
        logger.log(Level.INFO, "Start of the simulation with duration: " + durationInMonths + " months.");
        for (int i = 1; i <= durationInMonths; i++) {
            logger.log(Level.FINE, "Current month in simulation: " + i);
            traineesInWild = TraineeGenerator.getTrainees();

            if (i % 2 == 0) {
                logger.log(Level.FINER, "Training centre generated in month: " + i);
                trainingCentres.add(TrainingCentreGenerator.generateTrainingCentre());
            }
            TraineeAllocationManager.allocate(traineesInWild, waitingList, trainingCentres);
            if (isOutputAnnual && i % 12 == 0) {
                DisplayManager.printOutput(this, i / 12);
            }
        }
        if (!isOutputAnnual) {
            DisplayManager.printOutput(this, durationInMonths / 12);
        }
    }

    public long getNumberOfFullTrainingCentres() {
        return trainingCentres.stream().filter(TrainingCentre::trainingCentreIsFull).count();
    }

    public int getNumberOfTraineesInTraining() {
        return trainingCentres.stream().mapToInt(TrainingCentre::getCurrentCapacity).sum();
    }

    public Queue<Trainee> getTraineesInWild() {
        return traineesInWild;
    }

    public Queue<Trainee> getWaitingList() {
        return waitingList;
    }

    public ArrayList<TrainingCentre> getTrainingCentres() {
        return trainingCentres;
    }

    @Override
    public String toString() {
        return "Number of open centres: " + trainingCentres.size() +
                "\nNumber of full centres: " + getNumberOfFullTrainingCentres() +
                "\nNumber of trainees currently on training: " + getNumberOfTraineesInTraining() +
                "\nNumber of trainees on the waiting list: " + waitingList.size();
    }
}
