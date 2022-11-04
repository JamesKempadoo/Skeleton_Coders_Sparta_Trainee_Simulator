package com.sparta.skeleton.controller.trainee;

import com.sparta.skeleton.controller.client.ClientManager;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreManager;
import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;
import com.sparta.skeleton.utilities.logging.LoggerSingleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TraineeAllocationManager {

    static Logger logger = LoggerSingleton.getSingleton().getLogger();

    public static void allocate(Queue<Trainee> wildList, Deque<Trainee> waitList, ArrayList<TrainingCentre> centres) {
        logger.log(Level.INFO, "Waiting list size at the beginning of allocation: " + waitList.size());
        logger.log(Level.INFO, "Currently trainees in wild: " + wildList.size());
        mergeQueues(wildList, waitList);
        if (!waitList.isEmpty()) {
            allocateToTrainingCentres(waitList, centres);
        } else {
            logger.log(Level.FINE, "No trainees to allocate");
        }
        logger.log(Level.INFO, "Waiting list size at the end of allocation: " + waitList.size());
    }

    public static void allocateToTrainingCentres(Deque<Trainee> waitList, ArrayList<TrainingCentre> centres) {
        int traineeUptake;
        for (TrainingCentre centre : centres) { // fill each training centre before going to the next centre
            if (centre.trainingCentreIsFull()) {
                continue;
            }
            traineeUptake = TrainingCentreManager.generateRandomTraineeUptake();
            logger.log(Level.INFO, "Current Trainee Uptake Before populating: " + traineeUptake);
            traineeUptake = TrainingCentreManager.populateTrainingCentre(waitList, centre, traineeUptake);
            if (traineeUptake > 0) {
                logger.log(Level.FINE, "Log current centre has larger uptake than available trainees");
                break;
            }
        }
    }

    public static void benchTrainees(Deque<Trainee> graduates, ArrayList<TrainingCentre> trainingCentres) {
        ArrayList<Trainee> traineesToBeRemoved = new ArrayList<>();
        for (TrainingCentre centre : trainingCentres) {
            for (Trainee trainee : centre.getTraineesList()) {
                if (trainee.getMonthsTrained() >= 12) {
                    graduates.add(trainee);
                    traineesToBeRemoved.add(trainee);
                }
            }
            centre.getTraineesList().removeAll(traineesToBeRemoved);
        }
    }

    public static void allocateToClients(Deque<Trainee> graduates, ArrayList<Client> clients) {
        for (Client client : clients) { // fill each training centre before going to the next centre
            logger.log(Level.FINE, client.getClientID() + "::" + Arrays.toString(client.getRequiredTraineeType()) + "::" + client.getTraineeRequirement() + "::" + client.getCountMonths() + "::" + client.isHappy());
            if (!client.isHappy()) {
                continue;
            }
            logger.log(Level.FINE, String.valueOf(client.getClientID()));
            if (client.getCountMonths() % 12 == 0) {
                client.setCurrentTraineeRequirement();
            }
            logger.log(Level.FINE, "Current client graduate list before populating: " + "id: " + client.getClientID() + " list count: " + client.getTraineeList().size());
            ClientManager.populateClients(graduates, client);
            logger.log(Level.FINE, "Current client graduate list after populating: " + "id: " + client.getClientID() + " list count: " + client.getTraineeList().size());
        }
    }

    public static void sendToFrontOfWaitList(TrainingCentre trainingCentre, Deque<Trainee> waitList) {
        ArrayList<Trainee> trainees = trainingCentre.getTraineesList();
        for (Trainee trainee : trainees) {
            waitList.addFirst(trainee);
        }
    }

    public static void mergeQueues(Queue<Trainee> wildList, Queue<Trainee> waitList) {
        waitList.addAll(wildList);
        wildList.clear();
    }


}