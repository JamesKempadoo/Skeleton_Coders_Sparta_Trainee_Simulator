package com.sparta.skeleton.controller.trainee;

import com.sparta.skeleton.controller.trainingcentre.TrainingCentreManager;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentre;
import com.sparta.skeleton.util.log.LoggerSingleton;

import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TraineeAllocationManager {

    static Logger logger = LoggerSingleton.getSingleton().getLogger();

    static void allocate(Queue<Trainee> wildList, Queue<Trainee> waitList, ArrayList<TrainingCentre> centres) {
        int traineeUptake;
        waitList.addAll(wildList);

        if (!waitList.isEmpty()) {
            for (TrainingCentre centre : centres) { // fill each training centre before going to the next centre
                traineeUptake = TrainingCentreManager.generateRandomTraineeUptake();
                traineeUptake = TrainingCentreManager.populateTrainingCentre(waitList, centre, traineeUptake);
                if (traineeUptake > 0) {
                    logger.log(Level.FINE, "Log current centre has larger uptake than available trainees");
                    break;
                }
            }

        } else {
            logger.log(Level.FINE, "No trainees to allocate");
        }
    }

}

