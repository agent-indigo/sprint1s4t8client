
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
public class AircraftClientTest3 {
    @Mock
    private  AircraftClient mockAircraftClient;

    @Test
    public void  testAircraftList(){
        AircraftCLI aircraftCLI = new AircraftCLI();

        AircraftModel aircraft = new AircraftModel("Boeing 737", "Airline A", 150);
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

