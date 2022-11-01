package com.sparta.skeleton.util.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class CustomConsoleHandler {
	public static ConsoleHandler getConsoleHandler() {
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.OFF);
		//consoleHandler.setFilter(new CustomFilter());
		return consoleHandler;
	}
}
