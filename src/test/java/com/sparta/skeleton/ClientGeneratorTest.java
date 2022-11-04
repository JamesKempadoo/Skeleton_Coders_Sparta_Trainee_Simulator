package com.sparta.skeleton;

import com.sparta.skeleton.controller.client.ClientGenerator;
import com.sparta.skeleton.model.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientGeneratorTest {

    @Test
    @DisplayName("Test Client Generator returns a valid Client object")
    void testClientGeneratorReturnsAValidClientObject() {
        Client client = new Client();
        Assertions.assertTrue(client.getClass().equals(ClientGenerator.generateClient().getClass()));
    }
}
