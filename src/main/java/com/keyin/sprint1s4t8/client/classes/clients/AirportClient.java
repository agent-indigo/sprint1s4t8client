//AirportClient
package com.keyin.sprint1s4t8.client.classes.clients;
import com.keyin.sprint1s4t8.client.classes.abstracts.Client;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
public final class AirportClient extends Client {

    private AirportModel airport;
    private List<AirportModel> airports;
    private LinkedList<AircraftModel> aircrafts;
    private LinkedList<PassengerModel> passengers;
    public AirportClient() {

        super("airports");

    }

    public List<AirportModel> list() {

        try {

            this.airports = mapper.readValue(get(), new TypeReference<List<AirportModel>>() {});
            return airports;
        } catch (JsonProcessingException jsonProcessingException) {

            jsonProcessingException.printStackTrace();

            return null;

        }

    }

    public AirportModel show(int id) {

        this.address = address + id;

        try {

            this.airport = mapper.readValue(get(), new TypeReference<AirportModel>() {});
            return airport;
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return null;

        }

    }

    public String add(AirportModel airport) {

        try {

            this.url = URL.of(uri, null);
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.getOutputStream().write(mapper.writeValueAsString(airport).getBytes());
            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();

        }

    }

    public String edit(int id, AirportModel update) {
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

    public LinkedList<AircraftModel> listAircrafts(int id) {

        try {

            for (AirportModel airport : list()) {
                if (airport.getId() == id) {
                    this.aircrafts = mapper.convertValue(airport.getAircrafts(), new TypeReference<LinkedList<AircraftModel>>() {});
                }

            }

            return aircrafts;

        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return null;

        }

    }

    public String addAircraft(int id, AircraftModel aircraft) {
        this.address = address + id + "/aircrafts";

        try {

            for (AirportModel airport : list()) {
                if (airport.getId() == id) {
                    this.url = URL.of(uri, null);
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.getOutputStream().write(mapper.writeValueAsString(aircraft).getBytes());

                }

            }

            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();

        }

    }

    public String deleteAircraft(int id, int index) {
        this.address = address + id + "/aircrafts/" + index;

        try {

            for (AirportModel airport : list()) {
                if (airport.getId() == id) {
                    this.url = URL.of(uri, null);
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestMethod("DELETE");

                }

            }

            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();

        }

    }

    public LinkedList<PassengerModel> listPassengers(int id) {

        try {

            for (AirportModel airport : list()) {
                if (airport.getId() == id) {
                    this.passengers = mapper.convertValue(airport.getPassengers(), new TypeReference<LinkedList<PassengerModel>>() {});

                }

            }

            return passengers;
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return null;

        }

    }

    public String addPassenger(int id, PassengerModel passenger) {
        this.address = address + id + "/passengers";

        try {

            for (AirportModel airport : list()) {
                if (airport.getId() == id) {
                    this.url = URL.of(uri, null);
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.getOutputStream().write(mapper.writeValueAsString(passenger).getBytes());

                }

            }

            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();

        }

    }

    public String deletePassenger(int id, int index) {
        this.address = address + id + "/passengers/" + index;

        try {

            for (AirportModel airport : list()) {
                if (airport.getId() == id) {
                    this.url = URL.of(uri, null);
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestMethod("DELETE");
                }

            }

            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();

        }

    }

}