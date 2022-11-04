package com.sparta.skeleton.controller.client;

import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.model.trainees.Trainee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class ClientManager {

    public static void populateClients(Deque<Trainee> graduates, Client client) {
        ArrayList<Trainee> notMatchingClientType = new ArrayList<>();

        while (!graduates.isEmpty()) {
            if (Arrays.stream(client.getRequiredTraineeType()).anyMatch(s -> {
                assert graduates.peek() != null;
                return s.equals(graduates.peek().getCourseType());
            })) {
                if (!client.addTrainee(graduates.remove())) {
                    break;
                }
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
