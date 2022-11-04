package com.sparta.skeleton;

import com.sparta.skeleton.model.simulation.SimulationSystem;
import com.sparta.skeleton.utilities.logging.LoggerSingleton;
import com.sparta.skeleton.view.DisplayManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class SimulationLoader {

    private static final String PATH_PREFIX = "src/main/resources/";
    Logger logger = LoggerSingleton.getSingleton().getLogger();

    public void start() {
        logger.log(Level.INFO, "\n \n NEW SIMULATION HAS STARTED");
        Scanner in = new Scanner(System.in);
        String userInput;
        boolean isNumOfYears;
        do {
            DisplayManager.displayConfigurationOptions();
            do {
                Pattern pattern = Pattern.compile("[0-9]+|.*.txt");
                try {
                    userInput = in.next(pattern);
                    pattern = Pattern.compile("[0-9]+");
                    isNumOfYears = pattern.matcher(userInput).matches();
                    break;
                } catch (InputMismatchException e) {
                    DisplayManager.printWrongInputMessage(in.next());
                    in.nextLine();
                }
            } while (true);
            String outputFrequency;
            DisplayManager.displayOutputOptions();
            do {
                try {
                    Pattern pattern = Pattern.compile("[ymf]");
                    outputFrequency = in.next(pattern);
                    break;
                } catch (InputMismatchException e) {
                    DisplayManager.printWrongFrequencyInput(in.next());
                    in.nextLine();
                }
            } while (true);
            if (isNumOfYears) {
                runSimulationForSingleInput(Integer.parseInt(userInput), outputFrequency);
            } else {
                runSimulationFromFile(PATH_PREFIX + userInput, outputFrequency);
            }
            DisplayManager.displayExitOption();
        } while (!in.next().equalsIgnoreCase("e"));
    }

    private static void runSimulationForSingleInput(int userInput, String outputFrequency) {
        SimulationSystem simulationSystem = new SimulationSystem();
        simulationSystem.runSimulation(userInput, outputFrequency);
    }

    private void runSimulationFromFile(String filename, String outputFrequency) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineCounter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                lineCounter++;
                int numOfYears;
                try {
                    numOfYears = Integer.parseInt(line.split(" ")[0]);
                } catch (NumberFormatException e) {
                    DisplayManager.printErrorInFile(line.split(" ")[0], lineCounter);
                    continue;
                }
                runSimulationForSingleInput(numOfYears, outputFrequency);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
