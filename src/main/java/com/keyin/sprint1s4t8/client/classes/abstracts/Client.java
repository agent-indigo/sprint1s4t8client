package com.keyin.sprint1s4t8.client.classes.abstracts;
import com.keyin.sprint1s4t8.client.interfaces.Requests;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.HttpURLConnection;
public abstract class Client implements Requests {
    protected String address;
    protected URI uri;
    protected URL url;
    protected HttpURLConnection connection;
    protected HttpResponse<String> response;
    protected String requestBody;
    protected OutputStream outputStream;
    protected byte[] output;
    protected String responseBody;
    protected ObjectMapper mapper;
    public Client(String category) {
        this.address = "http://localhost:8080/" + category + "/";
        this.uri = URI.create(address);
        this.mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    @Override
    public final String get() {
        try {
            this.response = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().uri(uri).build(),
                HttpResponse.BodyHandlers.ofString()
            );
            System.out.printf("Status: %d", response.statusCode());
            this.responseBody = response.body();
        } catch (IOException | InterruptedException fuckup) {
            fuckup.printStackTrace();
        }
        return responseBody;
    }
    @Override
    public final String delete(String id) {
        this.address = address + id;
        try {
            this.url = URL.of(uri, null);
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json");
            return connection.getResponseMessage().toString();
        } catch (IOException blyat) {
            return blyat.getStackTrace().toString();
        }
    }
}