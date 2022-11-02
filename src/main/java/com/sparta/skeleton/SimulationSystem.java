package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainee.TraineeAllocationManager;
import com.sparta.skeleton.controller.trainee.TraineeGenerator;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreGenerator;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;
import com.sparta.skeleton.util.log.LoggerSingleton;

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

    public void runSimulation(int years) {
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
        }
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
}
