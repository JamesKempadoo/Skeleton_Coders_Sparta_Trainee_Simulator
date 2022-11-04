package com.sparta.skeleton.model.simulation;

import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;
import com.sparta.skeleton.utilities.TraineeHelper;
import com.sparta.skeleton.utilities.TrainingCentreHelper;

import java.util.List;

public class SimulationOutput {

    public static String getSimulationOutput(SimulationSystem simulationSystem) {
        StringBuilder sb = new StringBuilder();

        sb.append("Number of open centres: ").append(simulationSystem.trainingCentres.size());
        formatOutputByTrainingCentreType(simulationSystem,simulationSystem.trainingCentres, sb);


        sb.append("\nNumber of full centres: ").append(simulationSystem.getListOfFullTrainingCentres().size());
        formatOutputByTrainingCentreType(simulationSystem, simulationSystem.getListOfFullTrainingCentres(), sb);

        sb.append("\nNumber of closed centres: ").append(simulationSystem.closedTrainingCentres.size());
        formatOutputByTrainingCentreType(simulationSystem, simulationSystem.closedTrainingCentres, sb);

        sb.append("\nNumber of trainees currently on training: ").append(simulationSystem.getNumberOfTraineesInTraining());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeCourse).append(": ").append(simulationSystem.getNumberOfTraineesInTraining(traineeCourse));
        }

        sb.append("\nNumber of trainees currently on waiting list: ").append(simulationSystem.waitingList.size());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeCourse).append(": ").append(simulationSystem.getNumberOfTraineesInDequeByType(traineeCourse, simulationSystem.waitingList));
        }

        sb.append("\nNumber of trainees currently on graduates list: ").append(simulationSystem.graduatesList.size());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeCourse).append(": ").append(simulationSystem.getNumberOfTraineesInDequeByType(traineeCourse, simulationSystem.graduatesList));
        }

        sb.append("\nNumber of graduates currently with clients: ").append(simulationSystem.getNumberOfGraduatesInClients());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeCourse).append(": ").append(simulationSystem.getNumberOfTraineesInClients(traineeCourse));
        }

        sb.append("\nNumber of happy clients: ").append(simulationSystem.getListOfHappyClients().size());
        formatClientOutputByTraineeType(simulationSystem, simulationSystem.getListOfHappyClients(), sb);

        sb.append("\nNumber of unhappy clients: ").append(simulationSystem.getListOfUnhappyClients().size());
        formatClientOutputByTraineeType(simulationSystem, simulationSystem.getListOfUnhappyClients(), sb);
        return sb.toString();
    }

    private static void formatOutputByTrainingCentreType(SimulationSystem simulationSystem, List<TrainingCentre> trainingCentres, StringBuilder sb) {
        for (String trainingCentreType : TrainingCentreHelper.TRAINING_CENTRE_TYPES) {
            sb.append("\n  - ").append(trainingCentreType).append(": ").append(simulationSystem.getNumberOfTrainingCentresByType(trainingCentres, trainingCentreType));
        }
    }

    private static void formatClientOutputByTraineeType(SimulationSystem simulationSystem, List<Client> clients, StringBuilder sb) {
        for (String traineeType : TraineeHelper.TRAINEE_TYPES) {
            sb.append("\n  - ").append(traineeType).append(": ").append(simulationSystem.getNumberOfClientsByType(clients, traineeType));
        }
    }
}
