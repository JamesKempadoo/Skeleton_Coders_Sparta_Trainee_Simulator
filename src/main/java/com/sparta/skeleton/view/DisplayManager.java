package com.sparta.skeleton.view;

import com.sparta.skeleton.model.simulation.SimulationSystem;

public class DisplayManager {

    public static void displayConfigurationOptions() {
        System.out.print("""
                
                To run the simulation input one of the following options:
                                
                - The name of the file that contains durations of multiple simulations (e.g. example.txt)
                - Number of years to run a single simulation (positive integer number)
                                
                Enter your input here:""");
    }

    public static void displayOutputOptions() {
        System.out.print("Press 'y' to see the output annually or any other key to see only the final result:");
    }

    public static void displayExitOption() {
        System.out.print("\nPress 'e' to exit or any other key to run another simulation:");
    }

    public static void printOutput(SimulationSystem simulationSystem, int numOfYears) {

        System.out.println("\nThe result of the simulation at the end of year " + numOfYears + ":" +
                "\n" + simulationSystem.toString());

    }

    public static void printWrongInputMessage(String input) {
        System.out.print("Wrong input! Expected an integer greater than zero or the name of file and got \"" + input + "\"\nEnter your input here:");
    }

    public static void printErrorInFile(String s, int line) {
        System.out.println("Wrong input format in line " + line + "!\nExpected a positive integer and got \"" + s + "\"\n");
    }


}
