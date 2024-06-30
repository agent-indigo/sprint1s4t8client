//AircraftModelClient
package com.keyin.sprint1s4t8.client.classes.clients;

import com.keyin.sprint1s4t8.client.classes.abstracts.Client;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public final class AircraftModelClient extends Client {
    private AircraftModel aircraft;
    private List<AircraftModel> aircrafts;

    public AircraftModelClient() {
        super("aircrafts");
    }

    public List<AircraftModel> list() {
        try {
            this.aircrafts = mapper.readValue(get(), new TypeReference<List<AircraftModel>>() {});
            return aircrafts;
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return null;
        }
    }

    public AircraftModel show(int id) {
        this.address = address + id;
        try {
            this.aircraft = mapper.readValue(get(), new TypeReference<AircraftModel>() {});
            return aircraft;
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return null;
        }
    }

    public String add(AircraftModel aircraft) {
        try {
            this.url = URL.of(uri, null);
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.getOutputStream().write(mapper.writeValueAsString(aircraft).getBytes());
            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();
        }
    }

    public String edit(int id, AircraftModel update) {
        this.address = address + id;
        try {
            this.url = URL.of(uri, null);
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.getOutputStream().write(mapper.writeValueAsString(update).getBytes());
            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();
        }
    }
}