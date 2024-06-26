package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.clients.AircraftClient;
import com.keyin.sprint1s4t8.client.classes.clients.JsonProcessingException;
import com.keyin.sprint1s4t8.client.classes.clis.AircraftCLI;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AircraftClientTest {

    private AircraftClient aircraftClientUnderTest;
    private AircraftCLI aircraftCLI;
    private AircraftClient mockAircraftClient;

    @BeforeEach
    void setUp() {
        mockAircraftClient = Mockito.mock(AircraftClient.class);
        aircraftClientUnderTest = new AircraftClient();
        aircraftCLI = new AircraftCLI();
        aircraftCLI.setAircraftClient(mockAircraftClient);
    }



    @Test
    void testSetAircraftClient() {
        AircraftClient client = new AircraftClient();
        aircraftCLI.setAircraftClient(client);
        Assertions.assertEquals(client, aircraftCLI.getAircraftClient());
    }

    @Test
    void testGetAllAircrafts() {
        when(mockAircraftClient.getAllAircrafts()).thenReturn(List.of(new AircraftModel("1","hkhk","jkj",300)));

        List<AircraftModel> aircraftList = mockAircraftClient.getAllAircrafts();
        verify(mockAircraftClient, times(1)).getAllAircrafts();
    }


}