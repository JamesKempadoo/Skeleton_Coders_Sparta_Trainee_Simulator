package com.sparta.skeleton.controller.client;

import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class ClientManager {

    public static void populateClients(Deque<Trainee> graduates, Client client) {
        ArrayList<Trainee> notMatchingClientType = new ArrayList<>();

        while (client.getTraineeList().size() < client.getTraineeRequirement() && !graduates.isEmpty()) {
            if (Arrays.stream(client.getTypeOfTrainee()).anyMatch(s -> {
                assert graduates.peek() != null;
                return s.equals(graduates.peek().getCourseType());
            })) {
                client.addTrainee(graduates.remove());
            } else {
                notMatchingClientType.add(graduates.remove());
            }
        }
        for (Trainee trainee : notMatchingClientType) {
            graduates.addFirst(trainee);
        }
    }

    public static void incrementClientMonth(ArrayList<Client> clients) {
        for (Client client : clients) {
            client.incrementMonth();
        }
    }
}
