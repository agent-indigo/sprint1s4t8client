package com.keyin.sprint1s4t8.client.classes.clients;

import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class AircraftClient {

    public List<AircraftModel> getAllAirports() {
        List<AircraftModel> airports = new ArrayList<AircraftModel>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create('http;//localhost:8080')).build();

        try {
            HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println("***** " + response.body());
            } else {
                System.out.println("Error Status Code: " + response.statusCode());
            }

            airports = buildAirportListFromResponse(response.body());


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        return airports;
    }

}
