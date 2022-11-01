package com.sparta.skeleton;

import com.sparta.skeleton.util.log.LoggerSingleton;
import com.sparta.skeleton.view.DisplayManager;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimulationLoader {

    Logger logger = LoggerSingleton.getSingleton().getLogger();

    public void start() {
        logger.log(Level.INFO,"\n \n NEW SIMULATION HAS STARTED");
        Scanner in = new Scanner(System.in);
        DisplayManager.printQueryOfYear();
        int numOfYears;
        do {
            try {
                numOfYears = in.nextInt();
                if (numOfYears > 0) {
                    break;
                } else {
                    DisplayManager.printWrongInputMessage(String.valueOf(numOfYears));
                }
            } catch (InputMismatchException e) {
                DisplayManager.printWrongInputMessage(in.nextLine());
            }
        } while (true);
        SimulationSystem.runSimulation(numOfYears);
        DisplayManager.printOutput(SimulationSystem.getWaitingList(),SimulationSystem.getTrainingCentres());
    }

}
