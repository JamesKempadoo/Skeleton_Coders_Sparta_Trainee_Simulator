package com.sparta.skeleton;

import com.sparta.skeleton.controller.client.ClientManager;
import com.sparta.skeleton.controller.trainee.TraineeGenerator;
import com.sparta.skeleton.model.Client;
import com.sparta.skeleton.model.trainees.Trainee;
import com.sparta.skeleton.model.trainingCentres.TrainingCentre;
import org.junit.jupiter.api.*;

import java.util.*;

public class ClientManagerTest {


    private ArrayList<Client> clientsList = new ArrayList<>();
    private static Client client1 = new Client();



    void setup(Deque<Trainee> graduates) {

        Queue<Trainee> trainees = TraineeGenerator.generateTrainees(10);
        Trainee trainee1 = null;
        Trainee trainee2 = null;
        Trainee trainee3 = null;
        Trainee trainee4 = null;
        Trainee trainee5 = null;
        Trainee trainee6 = null;
        Trainee trainee7 = null;
        Trainee trainee8 = null;
        Trainee trainee9 = null;
        Trainee trainee10 = null;

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                trainee1 = trainees.remove();
            } else if (i == 1) {
                trainee2 = trainees.remove();
            } else if (i == 2) {
                trainee3 = trainees.remove();
            } else if (i == 3) {
                trainee4 = trainees.remove();
            } else if (i == 4) {
                trainee5 = trainees.remove();
            } else if (i == 5) {
                trainee6 = trainees.remove();
            } else if (i == 6) {
                trainee7 = trainees.remove();
            } else if (i == 7) {
                trainee8 = trainees.remove();
            } else if (i == 8) {
                trainee9 = trainees.remove();
            } else {
                trainee10 = trainees.remove();
            }
        }
        clientsList.add(client1);
        graduates.add(trainee1);
        graduates.add(trainee2);
        graduates.add(trainee3);
        graduates.add(trainee4);
        graduates.add(trainee5);
        graduates.add(trainee6);
        graduates.add(trainee7);
        graduates.add(trainee8);
        graduates.add(trainee9);
        graduates.add(trainee10);


    }

    @Test
    @DisplayName("Checking if client month can be incremented")
    void canIncrementClientMonth() {

        Deque<Trainee> graduates = new LinkedList<>();
        setup(graduates);
        int initialValue = client1.getCountMonths();
        ArrayList<Client> copyClientList = new ArrayList<>(clientsList);
        ClientManager.incrementClientMonth(copyClientList);

        Assertions.assertEquals(client1.getCountMonths(), initialValue+1);
    }

    @Test
    @RepeatedTest(10)
    @DisplayName("Checking client populate method")
    void checkPopulateClients(){
        Deque<Trainee> graduates = new LinkedList<>();
        setup(graduates);

        Client client1 = new Client();
        System.out.println("Client required Type: " + Arrays.toString(client1.getRequiredTraineeType()));

        int initialClientList = client1.getNumberOfGraduates();


        Deque<Trainee> graduatesCopy = new LinkedList<>(graduates);

        int expectedChange = 0;

        for (int i = 0; i < 10; i++) {
            String graduateCourseType = graduatesCopy.pop().getCourseType();
            System.out.println(graduateCourseType);
            if (Objects.equals(graduateCourseType, client1.getRequiredTraineeType()[0])){
                expectedChange++;
            }
        }
        ClientManager.populateClients(graduates, client1);

        Assertions.assertEquals(initialClientList + expectedChange, client1.getNumberOfGraduates());
    }
}
