//AircraftClient
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

public final class AircraftClient extends Client {
    private AircraftModel aircraft;
    private List<AircraftModel> aircrafts;
    private LinkedList<AirportModel> airports;
    private LinkedList<PassengerModel> passengers;

    public AircraftClient() {
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

    public LinkedList<AirportModel> listAirports(int id) {
        try {
            for (AircraftModel aircraft : list()) {
                if (aircraft.getId() == id) {
                    this.airports = mapper.convertValue(aircraft.getAirports(), new TypeReference<LinkedList<AirportModel>>() {});
                }
            }
            return airports;
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return null;
        }
    }

    public String addAirport(int id, AirportModel airport) {
        this.address = address + id + "/airports";
        try {
            for (AircraftModel aircraft : list()) {
                if (aircraft.getId() == id) {
                    this.url = URL.of(uri, null);
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.getOutputStream().write(mapper.writeValueAsString(airport).getBytes());
                }
            }
            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();
        }
    }

    public String deleteAirport(int id, int index) {
        this.address = address + id + "/airports/" + index;
        try {
            for (AircraftModel aircraft : list()) {
                if (aircraft.getId() == id) {
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
            for (AircraftModel aircraft : list()) {
                if (aircraft.getId() == id) {
                    this.passengers = mapper.convertValue(aircraft.getPassengers(), new TypeReference<LinkedList<PassengerModel>>() {});
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
            for (AircraftModel aircraft : list()) {
                if (aircraft.getId() == id) {
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
            for (AircraftModel aircraft : list()) {
                if (aircraft.getId() == id) {
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
