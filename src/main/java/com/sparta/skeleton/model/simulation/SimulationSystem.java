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
import com.sparta.skeleton.utilities.logging.LoggerSingleton;
import com.sparta.skeleton.view.DisplayManager;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SimulationSystem {
    private static final Logger LOGGER = LoggerSingleton.getSingleton().getLogger();
    protected final Deque<Trainee> waitingList = new LinkedList<>();
    protected final Deque<Trainee> graduatesList = new LinkedList<>();
    protected final ArrayList<Client> clients = new ArrayList<>();
    protected Queue<Trainee> traineesInWild = new LinkedList<>();

    protected final ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();
    protected final ArrayList<TrainingCentre> closedTrainingCentres = new ArrayList<>();

    public void runSimulation(int years, String outputFrequency) {
        JSONFileWriter.openJSONFile();
        int durationInMonths = years * 12;
        LOGGER.log(Level.INFO, "Start of the simulation with duration: " + durationInMonths + " months.");
        for (int i = 1; i <= durationInMonths; i++) {
            LOGGER.log(Level.FINE, "Current month in simulation: " + i);
            traineesInWild = TraineeGenerator.getTrainees();
            if (i % 2 == 0) {
                LOGGER.log(Level.FINER, "Training centre is generated");
                TrainingCentreGenerator.generateTrainingCentre(trainingCentres);
            }
            if (i % 12 == 0) {
                clients.add(ClientGenerator.generateClient());
                LOGGER.log(Level.FINER, "Current number of clients: " + clients.size());
            }
            TraineeAllocationManager.allocate(traineesInWild, waitingList, trainingCentres);
            incrementMonthCounter();
            TrainingCentreManager.close(trainingCentres, waitingList, closedTrainingCentres);
            TraineeAllocationManager.benchTrainees(graduatesList, trainingCentres);
            LOGGER.log(Level.FINE, "Number of graduates in graduate list: " + graduatesList.size());
            TraineeAllocationManager.allocateToClients(graduatesList, clients);
            if (outputFrequency.equals("y") && i % 12 == 0) {
                DisplayManager.printOutput(this, i / 12, false);
                JSONFileWriter.exportToJSON(this,i/12,"y");
            } else if (outputFrequency.equals("m")) {
                DisplayManager.printOutput(this, i, true);
                JSONFileWriter.exportToJSON(this,i,"m");
            } else if (outputFrequency.equals("f") && i == durationInMonths) {
                DisplayManager.printOutput(this, i / 12, false);
                JSONFileWriter.exportToJSON(this,i/12,"f");
            }
        }
        JSONFileWriter.closeJSONFile();
    }

    private void incrementMonthCounter() {
        ClientManager.incrementClientMonth(clients);
        TrainingCentreManager.incrementMonthCounter(trainingCentres);
        TraineeManager.incrementTraineeMonthCounter(trainingCentres);
    }

    public List<TrainingCentre> getListOfFullTrainingCentres() {
        return trainingCentres.stream().filter(TrainingCentre::trainingCentreIsFull).collect(Collectors.toList());
    }

    public List<Client> getListOfHappyClients() {
        return clients.stream().filter(Client::isHappy).collect(Collectors.toList());
    }

    public List<Client> getListOfUnhappyClients() {
        return clients.stream().filter(client -> !client.isHappy()).collect(Collectors.toList());
    }
    public long getNumberOfTrainingCentresByType(List<TrainingCentre> trainingCentres, String typeOfTrainingCentres) {
        return trainingCentres.stream().filter(trainingCentre -> trainingCentre.getClass().getSimpleName().equals(typeOfTrainingCentres)).count();
    }

    public long getNumberOfClientsByType(List<Client> clients, String traineeType) {
        return clients.stream().filter(client -> Arrays.asList(client.getRequiredTraineeType()).contains(traineeType)).count();
    }

    public int getNumberOfTraineesInTraining() {
        return trainingCentres.stream().mapToInt(TrainingCentre::getCurrentCapacity).sum();
    }

    public int getNumberOfGraduatesWithClients() {
        return clients.stream().mapToInt(Client::getNumberOfGraduates).sum();
    }

    public long getNumberOfTraineesInTraining(String typeOfTrainee) {
        long sum = 0;
        for (TrainingCentre trainingCentre : trainingCentres) {
            sum += trainingCentre.getTraineesList().stream().filter(trainee -> trainee.getCourseType().equals(typeOfTrainee)).count();
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

    public long getNumberOfTraineesInDequeByType(String typeOfTrainee, Deque<Trainee> traineesList) {
        return traineesList.stream().filter(trainee -> trainee.getCourseType().equals(typeOfTrainee)).count();

    }

    @Override
    public String toString() {
        return SimulationOutput.getSimulationOutput(this);
    }
}
