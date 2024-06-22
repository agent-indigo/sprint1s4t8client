
package com.keyin.sprint1s4t8.client.classes.clients;

import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AircraftClientTest {
    @Test
    public void testBuildAircraftListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": 1,\n\"model\": \"Boeing 737\",\n\"airline\": \"WestJet\",\n\"capacity\": 200\n},\n" +
                "{\n\"id\": 2,\n\"model\": \"Airbus A320\",\n\"airline\": \"Air Canada\",\n\"capacity\": 180\n}\n]";

        AircraftClient aircraftClientUnderTest = new AircraftClient();

        List<AircraftModel> aircraftList = aircraftClientUnderTest.buildAircraftListFromResponse(jsonResponse);

        Assertions.assertTrue(aircraftList.stream().anyMatch(a -> a.getModel().equals("Boeing 737")));
        Assertions.assertTrue(aircraftList.stream().anyMatch(a -> a.getModel().equals("Airbus A320")));
    }
}

