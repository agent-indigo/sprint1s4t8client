package com.keyin.sprint1s4t8.client.classes.clis;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.CityModel;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.CityClient;
import java.util.LinkedList;
import java.util.List;
public final class CityCLI extends CLI {
    private CityClient client;
    private CityModel city;
    private List<CityModel> cities;
    private LinkedList<AirportModel> airports;
    public CityCLI() {
        super();
        this.client = new CityClient();
        this.cities = client.list();
    }
    @Override
    public String list() {
        for (CityModel city : cities) {
            response.append(city.getId());
            response.append(",");
            response.append(city.getName());
            response.append(",");
            response.append(city.getProvTerrCode());
            if (cities.indexOf(city) < cities.size()) response.append("\n");
        }
        return response.toString();
    }
    @Override
    public String show(int id) {
        this.city = client.show(id);
        response.append(city.getId());
        response.append(",");
        response.append(city.getName());
        response.append(",");
        response.append(city.getProvTerrCode());
        if (cities.indexOf(city) < cities.size()) response.append("\n");
        return response.toString();
    }
    public void add(CityModel city) {
        client.add(city);
    }
    public void edit(int id, CityModel update) {
        client.edit(id, update);
    }
    @Override
    public void delete(int id) {
        client.delete(id);
    }
    public String listAirports(int id) {
        for (CityModel city : cities) {
            if (city.getId() == id) {
                this.airports = city.getAirports();
                for (AirportModel airport : airports) {
                    response.append(airport.getId());
                    response.append(",");
                    response.append(airport.getName());
                    response.append(",");
                    response.append(airport.getCode());
                    if (airports.indexOf(airport) < airports.size()) response.append("\n");
                }
            }
        }
        return response.toString();
    }
    public void addAirport(
        int id,
        AirportModel airport
    ) {
        for (CityModel city : cities) {
            if (city.getId() == id) client.addAirport(id, airport);
        }
    }
    public void deleteAirport(
        int id,
        int index
    ) {
        for (CityModel city : cities) {
            if (city.getId() == id) client.deleteAirport(id, index);
        }
    }
}