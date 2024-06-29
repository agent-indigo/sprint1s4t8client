package com.keyin.sprint1s4t8.client.classes.clients;

import com.keyin.sprint1s4t8.client.classes.abstracts.Client;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public final class PassengerClient extends Client {
    private PassengerModel passenger;
    private List<PassengerModel> passengers;
    private LinkedList<AircraftModel> planes;
    private LinkedList<AirportModel> airports;

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
            this.url = new URL(uri.toString()); // Перетворення URI у рядок
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.getOutputStream().write(mapper.writeValueAsString(passenger).getBytes());
            return connection.getResponseMessage();
        } catch (IOException ioException) {
            return ioException.getMessage();
        }
    }



    public String edit(String id, PassengerModel update) {
        this.address = address + id;
        try {
            this.url = new URL(uri.toString());
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.getOutputStream().write(mapper.writeValueAsString(update).getBytes());
            return connection.getResponseMessage();
        } catch (IOException ioException) {
            return ioException.getMessage();
        }
    }

//    public String delete(int id) {
//        this.address = address + id;
//        try {
//            this.url = new URL(uri.toString());
//            this.connection = (HttpURLConnection) url.openConnection();
//            connection.setDoOutput(true);
//            connection.setRequestMethod("DELETE");
//            return connection.getResponseMessage();
//        } catch (IOException ioException) {
//            return ioException.getMessage();
//        }
//    }

    public LinkedList<AircraftModel> listPlanes(int id) {
        try {
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
                    this.planes = mapper.convertValue(passenger.getPlanes(), new TypeReference<LinkedList<AircraftModel>>() {});
                }
            }
            return planes;
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return null;
        }
    }

    public String addPlane(int id, AircraftModel plane) {
        this.address = address + id + "/planes";
        try {
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
                    this.url = new URL(uri.toString());
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.getOutputStream().write(mapper.writeValueAsString(plane).getBytes());
                }
            }
            return connection.getResponseMessage();
        } catch (IOException ioException) {
            return ioException.getMessage();
        }
    }

    public String deletePlane(int id, int index) {
        this.address = address + id + "/planes/" + index;
        try {
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
                    this.url = new URL(uri.toString());
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestMethod("DELETE");
                }
            }
            return connection.getResponseMessage();
        } catch (IOException ioException) {
            return ioException.getMessage();
        }
    }

    public LinkedList<AirportModel> listAirports(int id) {
        try {
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
                    this.airports = mapper.convertValue(passenger.getAirports(), new TypeReference<LinkedList<AirportModel>>() {});
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
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
                    this.url = new URL(uri.toString());
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.getOutputStream().write(mapper.writeValueAsString(airport).getBytes());
                }
            }
            return connection.getResponseMessage();
        } catch (IOException ioException) {
            return ioException.getMessage();
        }
    }

    public String deleteAirport(int id, int index) {
        this.address = address + id + "/airports/" + index;
        try {
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
                    this.url = new URL(uri.toString());
                    this.connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestMethod("DELETE");
                }
            }
            return connection.getResponseMessage();
        } catch (IOException ioException) {
            return ioException.getMessage();
        }
    }
}
