package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainee.TraineeAllocationManager;
import com.sparta.skeleton.controller.trainee.TraineeGenerator;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreGenerator;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreManager;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentres.TrainingCentre;
import com.sparta.skeleton.util.log.LoggerSingleton;
import com.sparta.skeleton.view.DisplayManager;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SimulationSystem {

    static Logger logger = LoggerSingleton.getSingleton().getLogger();
    private final Deque<Trainee> waitingList = new LinkedList<>();

    private Queue<Trainee> traineesInWild = new LinkedList<>();

    private final ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();

    private final ArrayList<TrainingCentre> closedTrainingCentres = new ArrayList<>();

    public void runSimulation(int years, boolean isOutputAnnual) {
        int durationInMonths = years * 12;
        logger.log(Level.INFO, "Start of the simulation with duration: " + durationInMonths + " months.");
        for (int i = 1; i <= durationInMonths; i++) {
            logger.log(Level.FINE, "Current month in simulation: " + i);
            traineesInWild = TraineeGenerator.getTrainees();
            if (i % 2 == 0) {
                logger.log(Level.FINER, "Training centre generated in month: " + i);
                TrainingCentreGenerator.generateTrainingCentre(trainingCentres);
            }
            TrainingCentreManager.incrementMonthCounter(trainingCentres);
            TraineeAllocationManager.allocate(traineesInWild, waitingList, trainingCentres);
            TrainingCentreManager.close(trainingCentres,waitingList,closedTrainingCentres);
            if (isOutputAnnual && i % 12 == 0) {
                DisplayManager.printOutput(this, i / 12);
            }
        }
        if (!isOutputAnnual) {
            DisplayManager.printOutput(this, durationInMonths / 12);
        }
    }

    public List<TrainingCentre> getListOfFullTrainingCentres() {
        return trainingCentres.stream().filter(TrainingCentre::trainingCentreIsFull).collect(Collectors.toList());
    }

    public long getNumberOfTrainingCentresByType(List<TrainingCentre> trainingCentres, String typeOfTrainingCentres){
        return trainingCentres.stream().filter(trainingCentre -> trainingCentre.getClass().getSimpleName().equals(typeOfTrainingCentres)).count();
    }

    public int getNumberOfTraineesInTraining() {
        return trainingCentres.stream().mapToInt(TrainingCentre::getCurrentCapacity).sum();
    }

    public long getNumberOfTraineesInTraining(String typeOfTrainee) {
        long sum = 0;
        for (TrainingCentre trainingCentre : trainingCentres){
            sum += trainingCentre.getTraineeList().stream().filter(trainee -> trainee.getCourseType().equals(typeOfTrainee)).count();
        }
        return sum;
    }

    public long getNumberOfTraineesInWaitingListByType(String typeOfTrainee){
        return waitingList.stream().filter(trainee -> trainee.getCourseType().equals(typeOfTrainee)).count();

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
        String[] trainingCentreTypes =  {"TrainingHub", "Bootcamp", "TechCentre"};
        String[] traineeCourses =  {"Java", "C#", "Data", "DevOps", "Business"};
        StringBuilder sb = new StringBuilder();

        sb.append("Number of open centres: ").append(trainingCentres.size());
        formatOutputByTrainingCentreType(trainingCentres, trainingCentreTypes, sb);


        sb.append("\nNumber of full centres: ").append(getListOfFullTrainingCentres().size());
        formatOutputByTrainingCentreType(getListOfFullTrainingCentres(),trainingCentreTypes,sb);

        sb.append("\nNumber of closed centres: ").append(closedTrainingCentres.size());
        formatOutputByTrainingCentreType(closedTrainingCentres,trainingCentreTypes,sb);

        sb.append("\nNumber of trainees currently on training: ").append(getNumberOfTraineesInTraining());
        for (String traineeCourse : traineeCourses){
            sb.append("\n  ").append(traineeCourse).append(": ").append(getNumberOfTraineesInTraining(traineeCourse));
        }

        sb.append("\nNumber of trainees currently on waiting list: ").append(waitingList.size());
        for (String traineeCourse : traineeCourses){
            sb.append("\n  ").append(traineeCourse).append(": ").append(getNumberOfTraineesInWaitingListByType(traineeCourse));
        }

        return sb.toString();
    }

    private void formatOutputByTrainingCentreType(List<TrainingCentre> trainingCentres, String[] trainingCentreTypes, StringBuilder sb) {
        for (String trainingCentreType : trainingCentreTypes){
            sb.append("\n  ").append(trainingCentreType).append(": ").append(getNumberOfTrainingCentresByType(trainingCentres,trainingCentreType));
        }
    }
}
