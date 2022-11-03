package com.sparta.skeleton.controller.client;

import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.model.Trainee;
import com.sparta.skeleton.utilities.NonGaussianRandomBias;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ClientGenerator {


    static public Client generateClient() {
        return new Client(NonGaussianRandomBias.randomBiasGenerator());
    }

}
