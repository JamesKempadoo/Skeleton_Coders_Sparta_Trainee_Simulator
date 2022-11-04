package com.sparta.skeleton.model.simulation;

import com.sparta.skeleton.utilities.TraineeHelper;
import com.sparta.skeleton.utilities.TrainingCentreHelper;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONFileWriter {

    private static int fileCounter = 1;

    private static FileWriter fileWriter;

    private static final JSONObject finalObj = new JSONObject();

    public static void exportToJSON(SimulationSystem simulationSystem, int duration, boolean isOutputMonthly) {

        if (isOutputMonthly) {
            finalObj.put("month", duration);
        } else {
            finalObj.put("year", duration);
        }

        JSONObject openCentres = new JSONObject();
        openCentres.put("total", simulationSystem.trainingCentres.size());
        for (String trainingCentreType : TrainingCentreHelper.TRAINING_CENTRE_TYPES) {
            openCentres.put(trainingCentreType, simulationSystem.getNumberOfTrainingCentresByType(simulationSystem.trainingCentres, trainingCentreType));
        }
        finalObj.put("open_centres", openCentres);
        JSONObject fullCentres = new JSONObject();
        fullCentres.put("total", simulationSystem.getListOfFullTrainingCentres().size());
        for (String trainingCentreType : TrainingCentreHelper.TRAINING_CENTRE_TYPES) {
            fullCentres.put(trainingCentreType, simulationSystem.getNumberOfTrainingCentresByType(simulationSystem.getListOfFullTrainingCentres(), trainingCentreType));
        }
        finalObj.put("full_centres", fullCentres);

        JSONObject closedCentres = new JSONObject();
        closedCentres.put("total", simulationSystem.closedTrainingCentres.size());
        for (String trainingCentreType : TrainingCentreHelper.TRAINING_CENTRE_TYPES) {
            closedCentres.put(trainingCentreType, simulationSystem.getNumberOfTrainingCentresByType(simulationSystem.closedTrainingCentres, trainingCentreType));
        }
        finalObj.put("closed_centres", closedCentres);

        JSONObject traineesOnTrainingCentres = new JSONObject();
        traineesOnTrainingCentres.put("total", simulationSystem.getNumberOfTraineesInTraining());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            traineesOnTrainingCentres.put(traineeCourse, simulationSystem.getNumberOfTraineesInTraining(traineeCourse));
        }
        finalObj.put("trainees_training", traineesOnTrainingCentres);

        JSONObject traineesOnWaitingList = new JSONObject();
        traineesOnWaitingList.put("total", simulationSystem.waitingList.size());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            traineesOnWaitingList.put(traineeCourse, simulationSystem.getNumberOfTraineesInDequeByType(traineeCourse, simulationSystem.waitingList));
        }
        finalObj.put("trainees_waiting", traineesOnWaitingList);

        JSONObject graduates = new JSONObject();
        graduates.put("total", simulationSystem.graduatesList.size());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            graduates.put(traineeCourse, simulationSystem.getNumberOfTraineesInDequeByType(traineeCourse, simulationSystem.graduatesList));
        }
        finalObj.put("graduates", graduates);

        JSONObject graduatesWithClients = new JSONObject();
        graduatesWithClients.put("total", simulationSystem.getNumberOfGraduatesWithClients());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            graduatesWithClients.put(traineeCourse, simulationSystem.getNumberOfTraineesInClients(traineeCourse));
        }
        finalObj.put("graduates_placed", graduatesWithClients);

        JSONObject happyClients = new JSONObject();
        happyClients.put("total", simulationSystem.getListOfHappyClients().size());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            happyClients.put(traineeCourse, simulationSystem.getNumberOfClientsByType(simulationSystem.getListOfHappyClients(), traineeCourse));
        }
        finalObj.put("happy_clients", happyClients);

        JSONObject unhappyClients = new JSONObject();
        unhappyClients.put("total", simulationSystem.getListOfUnhappyClients().size());
        for (String traineeCourse : TraineeHelper.TRAINEE_TYPES) {
            unhappyClients.put(traineeCourse, simulationSystem.getNumberOfClientsByType(simulationSystem.getListOfUnhappyClients(), traineeCourse));
        }
        finalObj.put("unhappy_clients", unhappyClients);
    }

    public static void openJSONFile() {
        try {
            String filename = "simulationOutput" + fileCounter + ".json";
            fileWriter = new FileWriter("src/main/resources/" + filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileCounter++;
    }

    public static void closeJSONFile() {
        try {
            fileWriter.write(finalObj.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
