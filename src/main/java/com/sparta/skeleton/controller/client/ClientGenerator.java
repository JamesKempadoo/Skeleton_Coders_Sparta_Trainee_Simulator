package com.sparta.skeleton.controller.client;

import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.utilities.NonGaussianRandomBias;

public class ClientGenerator {


    static public Client generateClient() {
        return new Client(NonGaussianRandomBias.randomBiasGenerator());
    }

}
