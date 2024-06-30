
package com.keyin.sprint1s4t8.client.classes.clients;
import com.keyin.sprint1s4t8.client.classes.abstracts.Client;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public final class PassengerClient extends Client {
    private PassengerModel passenger;
    private List<PassengerModel> passengers;
    public PassengerClient() {
        super("passengers");
    }

    public List<PassengerModel> list() {
        try {
            this.passengers = mapper.readValue(get(), new TypeReference<List<PassengerModel>>() {});
            return passengers;
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return null;
        }
    }

    public PassengerModel show(int id) {
        this.address = address + id;
        try {
            this.passenger = mapper.readValue(get(), new TypeReference<PassengerModel>() {});
            return passenger;
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return null;
        }
    }

    public String add(PassengerModel passenger) {
        try {
            this.url = URL.of(uri, null);
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.getOutputStream().write(mapper.writeValueAsString(passenger).getBytes());
            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();
        }

    }
    public String edit(int id, PassengerModel update) {
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