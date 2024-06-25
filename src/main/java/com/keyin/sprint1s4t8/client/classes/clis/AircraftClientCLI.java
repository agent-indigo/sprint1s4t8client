
package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;

import java.util.List;

public class AircraftClientCLI {
    private String serverURL;

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }
    public List<AircraftModel> getAllAircrafts() {
        // Logic to fetch all aircraft from the server
        // Example placeholder return
        return List.of(
                new AircraftModel("Boeing 737", "Airline A", 150),
                new AircraftModel("Airbus A320", "Airline B", 180)
        );
    }
    public List<AirportModel> getAllAirports() {
        // Logic to fetch all airports from the server
        // Example placeholder return
        return List.of(
                new AirportModel("JFK International", new CityModel("New York")),
                new AirportModel("LAX International", new CityModel("Los Angeles"))
        );
    }
    public List<PassengerModel> getAllPassengers() {
        // Logic to fetch all passengers from the server
        // Example placeholder return
        return List.of(
                new PassengerModel(),
                new PassengerModel()
        );
    }
    public boolean getResponseFromHTTPRequest() {
        // Logic to perform HTTP request and return response status
        // Example placeholder return
        return true;
    }

    public class CityModel {
        public CityModel(String newYork) {
        }
    }
}

