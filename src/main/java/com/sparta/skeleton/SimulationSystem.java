package com.sparta.skeleton;

import com.sparta.skeleton.controller.trainee.TraineeAllocationManager;
import com.sparta.skeleton.controller.trainee.TraineeGenerator;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreGenerator;
import com.sparta.skeleton.controller.trainingcentre.TrainingCentreManager;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.model.TrainingCentres.TrainingCentre;
import com.sparta.skeleton.util.log.LoggerSingleton;
import com.sparta.skeleton.view.DisplayManager;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            TrainingCentreManager.close(trainingCentres,waitingList,closedTrainingCentres);
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

    public long getNumberOfClosedTrainingCentresByType(String typeOfTrainingCentres){
        return closedTrainingCentres.stream().filter(trainingCentre -> trainingCentre.getClass().getSimpleName().equals(typeOfTrainingCentres)).count();
    }

    public long getNumberOfOpenTrainingCentresByType(String typeOfTrainingCentres){
        return trainingCentres.stream().filter(trainingCentre -> trainingCentre.getClass().getSimpleName().equals(typeOfTrainingCentres)).count();
    }

    public long getNumberOfFullTrainingCentresByType(String typeOfTrainingCentres) {
        return trainingCentres.stream().filter(trainingCentre -> trainingCentre.trainingCentreIsFull() && trainingCentre.getClass().getSimpleName().equals(typeOfTrainingCentres)).count();
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

    @Override
    public String toString() {
        String[] trainingCentreTypes =  {"TrainingHub", "Bootcamp", "TechCentre"};
        String[] traineeCourses =  {"Java", "C#", "Data", "DevOps", "Business"};
        StringBuilder sb = new StringBuilder();

        sb.append("Number of open centres: ").append(trainingCentres.size());
        for (String trainingCentreType : trainingCentreTypes){
            sb.append("\n\tNumber of open centres (").append(trainingCentreType).append("): ").append(getNumberOfOpenTrainingCentresByType(trainingCentreType));
        }


        sb.append("\nNumber of full centres: ").append(getNumberOfFullTrainingCentres());
        for (String trainingCentreType : trainingCentreTypes){
            sb.append("\n\tNumber of full centres (").append(trainingCentreType).append("): ").append(getNumberOfFullTrainingCentresByType(trainingCentreType));
        }


        sb.append("\nNumber of closed centres: ").append(closedTrainingCentres.size());
        for (String trainingCentreType : trainingCentreTypes){
            sb.append("\n\tNumber of closed centres (").append(trainingCentreType).append("): ").append(getNumberOfClosedTrainingCentresByType(trainingCentreType));
        }


        sb.append("\nNumber of trainees currently on training: ").append(getNumberOfTraineesInTraining());
        for (String traineeCourse : traineeCourses){
            sb.append("\n\tNumber of trainees (").append(traineeCourse).append("): ").append(getNumberOfTraineesInTraining(traineeCourse));
        }


        sb.append("\nNumber of trainees currently on waiting list: ").append(waitingList.size());
        for (String traineeCourse : traineeCourses){
            sb.append("\n\tNumber of trainees (").append(traineeCourse).append("): ").append(getNumberOfTraineesInWaitingListByType(traineeCourse));
        }

        return sb.toString();

//
//        return "Number of open centres: " + trainingCentres.size() +
//                "\n\tNumber of open centres (Training Hub): " + getOpenCentreByType(trainingCentres, "Training Hub") +
//                "\n\tNumber of open centres (Bootcamp): " + getOpenCentreByType(trainingCentres, "Bootcamp") +
//                "\n\tNumber of open centres (Tech Centre): " + getOpenCentreByType(trainingCentres, "Tech Centre") +
//
//                "\nNumber of full centres: " + getNumberOfFullTrainingCentres() +
//                "\n\tNumber of full centres (Training Hub): " + getNumberOfFullTrainingCentresByType("Training Hub") +
//                "\n\tNumber of full centres (Bootcamp): " + getNumberOfFullTrainingCentresByType("Bootcamp") +
//                "\n\tNumber of full centres (Tech Centre): " + getNumberOfFullTrainingCentresByType("Tech Centre") +
//
//                "\nNumber of closed centres: " + closedTrainingCentres.size() +
//                "\n\tNumber of closed centres (Training Hub): " + getNumberOfClosedTrainingCentresByType("Training Hub") +
//                "\n\tNumber of closed centres (Bootcamp): " + getNumberOfClosedTrainingCentresByType("Bootcamp") +
//                "\n\tNumber of closed centres (Tech Centre): " + getNumberOfClosedTrainingCentresByType("Tech Centre") +
//
//                "\nNumber of trainees currently on training: " + getNumberOfTraineesInTraining() +
//                "\n\tNumber of trainees (Java): " +  getNumberOfTraineesInTraining("Java") +
//                "\n\tNumber of trainees (C#): " +  getNumberOfTraineesInTraining("C#") +
//                "\n\tNumber of trainees (Data): " +  getNumberOfTraineesInTraining("Data") +
//                "\n\tNumber of trainees (DevOps): " +  getNumberOfTraineesInTraining("DevOps") +
//                "\n\tNumber of trainees (Business): " +  getNumberOfTraineesInTraining("Business") +
//
//                "\nNumber of trainees on the waiting list: " + waitingList.size();
    }
}
