package com.keyin.sprint1s4t8.client.classes.clients;
import com.keyin.sprint1s4t8.client.classes.abstracts.Client;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.CityModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
public final class CityClient extends Client {
    private CityModel city;
    private List<CityModel> cities;
    private LinkedList<AirportModel> airports;
    public CityClient() {
        super("cities");
    }
    public List<CityModel> list() {
        try {
            this.cities = mapper.readValue(get(), new TypeReference<List<CityModel>>(){});
            return cities;
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return null;
        }
    }
    public CityModel show(int id) {
        this.address = address + id;
        try {
            this.city = mapper.readValue(get(), new TypeReference<CityModel>(){});
            return city;
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
            return null;
        }
    }
    public String add(CityModel city) {
        try {
            this.url = URL.of(uri, null);
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.getOutputStream().write(mapper.writeValueAsString(city).getBytes());
            return connection.getResponseMessage().toString();
        } catch (IOException ioException) {
            return ioException.getStackTrace().toString();
        }
    }
    public String edit(
        String id,
        CityModel update
    ) {
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
            for (CityModel city : list()) {
                if (city.getId() == id) {
                    this.airports = mapper.convertValue(city.getAirports(), new TypeReference<LinkedList<AirportModel>>(){});
                }
            }
            return airports;
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return null;
        }
    }
    public String addAirport(
        int id,
        AirportModel airport
    ) {
        this.address = address + id + "/airports";
        try {
            for (CityModel city : list()) {
                if (city.getId() == id) {
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
    public String deleteAirport(
        int id,
        int index
    ) {
        this.address = address + id + "/airports/" + index;
        try {
            for (CityModel city : list()) {
                if (city.getId() == id) {
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