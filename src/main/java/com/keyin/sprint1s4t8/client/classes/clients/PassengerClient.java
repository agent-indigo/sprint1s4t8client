
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

public final class PassengerClient extends Client {
    private PassengerModel passenger;
    private List<PassengerModel> passengers;
    private LinkedList<AircraftModel> aircrafts;
    private LinkedList<AirportModel> airports;
    public PassengerClient() {
        super("passengers");
    }

    public List<PassengerModel> list() {
        try {
            this.passengers = mapper.readValue(get(), new TypeReference<List<PassengerModel>>() {
            });
            return passengers;
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return null;
        }
    }

    public PassengerModel show(int id) {
        this.address = address + id;
        try {
            this.passenger = mapper.readValue(get(), new TypeReference<PassengerModel>() {
            });
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

    public LinkedList<AircraftModel> listAircrafts(int id) {
        try {
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
                    this.aircrafts = mapper.convertValue(passenger.getAircrafts(), new TypeReference<LinkedList<AircraftModel>>() {
                    });
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
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
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
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
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

    public LinkedList<AirportModel> listAirports(int id) {
        try {
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
                    this.airports = mapper.convertValue(passenger.getAirports(), new TypeReference<LinkedList<AirportModel>>() {
                    });
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
            for (PassengerModel passenger : list()) {
                if (passenger.getId() == id) {
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