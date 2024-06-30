// AirportCLI
package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.models.AirportModel;

import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;

import com.keyin.sprint1s4t8.client.classes.clients.AirportClient;

import java.util.List;

public final class AirportCLI extends CLI {

    private AirportClient client;

    private AirportModel airport;

    private List<AirportModel> airports;

    public AirportCLI() {

        super();

        this.client = new AirportClient();

        this.airports = client.list();

    }

    @Override

    public String list() {

        for (AirportModel airport : airports) {

            response.append(airport.getId());

            response.append(",");

            response.append(airport.getName());

            response.append(",");

            response.append(airport.getCode());

            if (airports.indexOf(airport) < airports.size()) response.append("\n");

        }

        return response.toString();

    }

    @Override

    public String show(int id) {

        this.airport = client.show(id);

        response.append(airport.getId());

        response.append(",");

        response.append(airport.getName());

        response.append(",");

        response.append(airport.getCode());

        if (airports.indexOf(airport) < airports.size()) response.append("\n");

        return response.toString();

    }

    public void add(AirportModel airport) {

        client.add(airport);

    }

    public void edit(int id, AirportModel update) {

        client.edit(id, update);

    }

    @Override

    public void delete(int id) {

        client.delete(id);

    }

}