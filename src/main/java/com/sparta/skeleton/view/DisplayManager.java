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
        System.out.print("""
                Choose how often you want to see the simulation state:
                           
                - 'y' to display annual output
                - 'm' to display monthly output
                - 'f' to display only the final output
                                
                Enter your input here:""");
    }

    public static void displayExitOption() {
        System.out.print("\nPress 'e' to exit or any other key to run another simulation:");
    }

    public static void printOutput(SimulationSystem simulationSystem, int period, boolean isOutputMonthly) {
        if (isOutputMonthly) {
            System.out.println("\n-------------------- End of month " + period + " --------------------" +
                    "\n" + simulationSystem.toString());
        } else {
            System.out.println("\n-------------------- End of year " + period + " --------------------" +
                    "\n" + simulationSystem.toString());
        }

    }

    public static void printWrongInputMessage(String input) {
        System.out.print("Wrong input! Expected an integer greater than zero or the name of file and got \"" + input + "\"\nEnter your input here:");
    }

    public static void printWrongFrequencyInput(String input) {
        System.out.print("Wrong input! Expected 'y', 'm' or 'f' and got \"" + input + "\"\nEnter your input here:");
    }

    public static void printErrorInFile(String s, int line) {
        System.out.println("Wrong input format in line " + line + "!\nExpected a positive integer and got \"" + s + "\"\n");
    }


    public static void printWrongBoundsMessage() {
        System.out.println("Given max bound is lower than min bound!\nBound is set back to default.");
    }

    public static void printErrorInPropertiesFile() {
        System.out.println("Error in loading properties file!\nValues are set back to default.");
    }
}
