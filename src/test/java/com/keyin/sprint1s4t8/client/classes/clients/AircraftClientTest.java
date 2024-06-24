
package com.keyin.sprint1s4t8.client.classes.clients;

import com.keyin.sprint1s4t8.client.classes.clis.AircraftCLI;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class AircraftClientTest {
    @Mock
    private  AircraftClient mockAircraftClient;
    @Ignore
    @Test
    public void testBuildAircraftListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": 1,\n\"model\": \"Boeing 737\",\n\"airline\": \"WestJet\",\n\"capacity\": 200\n},\n" +
                "{\n\"id\": 2,\n\"model\": \"Airbus A320\",\n\"airline\": \"Air Canada\",\n\"capacity\": 180\n}\n]";

        AircraftClient aircraftClientUnderTest = new AircraftClient();

        List<AircraftModel> aircraftList = aircraftClientUnderTest.buildAircraftListFromResponse(jsonResponse);

        Assertions.assertTrue(aircraftList.stream().anyMatch(a -> a.getModel().equals("Boeing 737")));
        Assertions.assertTrue(aircraftList.stream().anyMatch(a -> a.getModel().equals("Airbus A320")));
    }

    @Test
    public void  testAircraftList(){
        AircraftCLI aircraftCLI = new AircraftCLI();

        AircraftModel aircraft = new AircraftModel();
        aircraft.setAirline("WestJet");
        aircraft.setModel("737");
        aircraft.setCapacity(200);

        List<AircraftModel> aircraftModels = new ArrayList<>();
        aircraftModels.add(aircraft);
        aircraftCLI.setAircraftClient(mockAircraftClient);
        Mockito.when((mockAircraftClient.getAllAircrafts())).thenReturn(aircraftModels);
        Assertions.assertTrue(aircraftCLI.generateAircraftReport().contains("737"));

    }


}

