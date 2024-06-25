package com.keyin.sprint1s4t8.client.classes.clients;
import com.keyin.sprint1s4t8.client.classes.abstracts.Client;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public final class AircraftClient extends Client {
    private AircraftModel plane;
    private List<AircraftModel> planes;
    public AircraftClient() {
        super("aircraft");
        this.plane = new AircraftModel();
        this.planes = new ArrayList<AircraftModel>();
    }
    public List<AircraftModel> list() {
        try {
            this.planes = mapper.readValue(get(), new TypeReference<List<AircraftModel>>(){});
        } catch (JsonProcessingException fuckup) {
            fuckup.printStackTrace();
        }
        return planes;
    }
    public AircraftModel show(String id) {
        this.address = address + id;
        try {
            this.plane = mapper.readValue(get(), new TypeReference<AircraftModel>(){});
        } catch (JsonProcessingException blyat) {
            blyat.printStackTrace();
        }
        return plane;
    }
    public String add(AircraftModel aircraft) {
        try {
            this.output = mapper.writeValueAsBytes(aircraft);
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
    public String edit(String id, AircraftModel update) {
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