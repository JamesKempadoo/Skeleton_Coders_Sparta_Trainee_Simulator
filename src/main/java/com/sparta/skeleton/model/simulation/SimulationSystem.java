package com.sparta.skeleton.model.simulation;

import com.sparta.skeleton.controller.client.ClientGenerator;
import com.sparta.skeleton.controller.client.ClientManager;
import com.sparta.skeleton.controller.trainee.TraineeAllocationManager;
import com.sparta.skeleton.controller.trainee.TraineeGenerator;
import com.sparta.skeleton.controller.trainee.TraineeManager;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreGenerator;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreManager;
import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;
import com.sparta.skeleton.utilities.TraineeHelper;
import com.sparta.skeleton.utilities.TrainingCentreHelper;
import com.sparta.skeleton.utilities.logging.LoggerSingleton;
import com.sparta.skeleton.view.DisplayManager;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SimulationSystem {

    static Logger logger = LoggerSingleton.getSingleton().getLogger();
    protected final Deque<Trainee> waitingList = new LinkedList<>();

    protected final Deque<Trainee> graduatesList = new LinkedList<>();

    protected final ArrayList<Client> clients = new ArrayList<>();

    protected Queue<Trainee> traineesInWild = new LinkedList<>();

    protected final ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();

    protected final ArrayList<TrainingCentre> closedTrainingCentres = new ArrayList<>();

    public void runSimulation(int years, boolean isOutputMonthly) {
        int durationInMonths = years * 12;
        logger.log(Level.INFO, "Start of the simulation with duration: " + durationInMonths + " months.");
        for (int i = 1; i <= durationInMonths; i++) {
            logger.log(Level.FINE, "Current month in simulation: " + i);
            traineesInWild = TraineeGenerator.getTrainees();
            if (i % 2 == 0) {
                logger.log(Level.FINER, "Training centre generated in month: " + i);
                TrainingCentreGenerator.generateTrainingCentre(trainingCentres);
            }
            if (i % 12 == 0) {
                clients.add(ClientGenerator.generateClient());
                Client x = clients.get(clients.size()-1);
                System.out.println(x.getTraineeRequirement() + "::" + Arrays.toString(x.getTypeOfTrainee()));
                logger.log(Level.FINER, "Number of clients in month " + i + ": " + clients.size());
            }
            TrainingCentreManager.incrementMonthCounter(trainingCentres);
            ClientManager.incrementClientMonth(clients);
            TraineeAllocationManager.allocate(traineesInWild, waitingList, trainingCentres);
            TraineeManager.incrementTraineeMonthCounter(trainingCentres);
            TrainingCentreManager.close(trainingCentres, waitingList, closedTrainingCentres);
            TraineeAllocationManager.benchTrainees(graduatesList, trainingCentres);
            logger.log(Level.FINE, "Number of graduates in graduate list: " + graduatesList.size());
            TraineeAllocationManager.allocateToClients(graduatesList, clients);
            if (isOutputMonthly && i < durationInMonths) {
                DisplayManager.printOutput(this, i, true);
            } else if (i == durationInMonths) {
                DisplayManager.printOutput(this, durationInMonths / 12, false);
            }
        }
    }

    public List<TrainingCentre> getListOfFullTrainingCentres() {
        return trainingCentres.stream().filter(TrainingCentre::trainingCentreIsFull).collect(Collectors.toList());
    }

    public long getNumberOfTrainingCentresByType(List<TrainingCentre> trainingCentres, String typeOfTrainingCentres) {
        return trainingCentres.stream().filter(trainingCentre -> trainingCentre.getClass().getSimpleName().equals(typeOfTrainingCentres)).count();
    }

    public int getNumberOfTraineesInTraining() {
        return trainingCentres.stream().mapToInt(TrainingCentre::getCurrentCapacity).sum();
    }

    public int getNumberOfGraduatesInClients() {
        return clients.stream().mapToInt(Client::getNumberOfGraduates).sum();
    }

    public long getNumberOfTraineesInTraining(String typeOfTrainee) {
        long sum = 0;
        for (TrainingCentre trainingCentre : trainingCentres) {
            sum += trainingCentre.getTraineeList().stream().filter(trainee -> trainee.getCourseType().equals(typeOfTrainee)).count();
        }
        return sum;
    }

    public long getNumberOfTraineesInClients(String typeOfTrainee) {
        long sum = 0;
        for (Client client : clients) {
            sum += client.getTraineeList().stream().filter(trainee -> trainee.getCourseType().equals(typeOfTrainee)).count();
        }
        return sum;
    }

    public long getNumberOfTraineesInWaitingListByType(String typeOfTrainee) {
        return waitingList.stream().filter(trainee -> trainee.getCourseType().equals(typeOfTrainee)).count();

    }

    public long getNumberOfTraineesInGraduateListByType(String typeOfTrainee) {
        return graduatesList.stream().filter(trainee -> trainee.getCourseType().equals(typeOfTrainee)).count();

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

    public ArrayList<TrainingCentre> getClosedTrainingCentres() {
        return closedTrainingCentres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        sb.append("Number of open centres: ").append(trainingCentres.size());
        formatOutputByTrainingCentreType(trainingCentres, sb);


        sb.append("\nNumber of full centres: ").append(getListOfFullTrainingCentres().size());
        formatOutputByTrainingCentreType(getListOfFullTrainingCentres(), sb);

        sb.append("\nNumber of closed centres: ").append(closedTrainingCentres.size());
        formatOutputByTrainingCentreType(closedTrainingCentres, sb);

        sb.append("\nNumber of trainees currently on training: ").append(getNumberOfTraineesInTraining());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeCourse).append(": ").append(getNumberOfTraineesInTraining(traineeCourse));
        }

        sb.append("\nNumber of trainees currently on waiting list: ").append(waitingList.size());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeCourse).append(": ").append(getNumberOfTraineesInWaitingListByType(traineeCourse));
        }

        sb.append("\nNumber of trainees currently on graduates list: ").append(graduatesList.size());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeCourse).append(": ").append(getNumberOfTraineesInGraduateListByType(traineeCourse));
        }

        sb.append("\nNumber of graduates currently on clients: ").append(getNumberOfGraduatesInClients());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeCourse).append(": ").append(getNumberOfTraineesInClients(traineeCourse));
        }
        return sb.toString();
    }

    private void formatOutputByTrainingCentreType(List<TrainingCentre> trainingCentres, StringBuilder sb) {
        for (String trainingCentreType : TrainingCentreHelper.TRAINING_CENTRE_TYPES) {
            sb.append("\n  - ").append(trainingCentreType).append(": ").append(getNumberOfTrainingCentresByType(trainingCentres, trainingCentreType));
        }
    }
}
