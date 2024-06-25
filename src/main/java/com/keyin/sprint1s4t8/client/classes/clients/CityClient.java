package com.keyin.sprint1s4t8.client.classes.clients;
import com.keyin.sprint1s4t8.client.classes.abstracts.Client;
import com.keyin.sprint1s4t8.client.classes.models.CityModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public final class CityClient extends Client {
    private CityModel city;
    private List<CityModel> cities;
    public CityClient() {
        super("cities");
        this.city = new CityModel();
        this.cities = new ArrayList<CityModel>();
    }
    public List<CityModel> list() {
        try {
            this.cities = mapper.readValue(get(), new TypeReference<List<CityModel>>(){});
        } catch (JsonProcessingException fuckup) {
            fuckup.printStackTrace();
        }
        return cities;
    }
    public CityModel show(String id) {
        this.address = address + id;
        try {
            this.city = mapper.readValue(get(), new TypeReference<CityModel>(){});
        } catch (JsonProcessingException blyat) {
            blyat.printStackTrace();
        }
        return city;
    }
    public String add(CityModel city) {
        try {
            this.output = mapper.writeValueAsBytes(city);
            this.url = URL.of(uri, null);
            this.connection = (HttpURLConnection) url.openConnection();
            this.outputStream = connection.getOutputStream();
            outputStream.write(output, 0, output.length);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            return connection.getResponseMessage().toString();
        } catch (IOException bullshit) {
            return bullshit.getStackTrace().toString();
        }
    }
    public String edit(String id, CityModel update) {
        this.address = address + id;
        try {
            this.output = mapper.writeValueAsBytes(update);
            this.url = URL.of(uri, null);
            this.connection = (HttpURLConnection) url.openConnection();
            this.outputStream = connection.getOutputStream();
            outputStream.write(output, 0, output.length);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            return connection.getResponseMessage().toString();
        } catch (IOException bullshit) {
            return bullshit.getStackTrace().toString();
        }
    }
}