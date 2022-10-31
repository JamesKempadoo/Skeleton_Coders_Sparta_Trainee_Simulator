package com.sparta.skeleton;

import com.sparta.skeleton.util.log.LoggerSingleton;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SimulationLoader {

    Logger logger = LoggerSingleton.getSingleton().getLogger();

    public void start() {
        logger.log(Level.INFO, "Example");

    }

}
