//AircraftCLI
package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.AircraftClient;

import java.util.LinkedList;
import java.util.List;

public final class AircraftCLI extends CLI {
    private AircraftClient client;
    private AircraftModel aircraft;
    private List<AircraftModel> aircrafts;
    private LinkedList<AirportModel> airports;
    private LinkedList<PassengerModel> passengers;

    public AircraftCLI() {
        super();
        this.client = new AircraftClient();
        this.aircrafts = client.list();
    }

    @Override
    public String list() {
        for (AircraftModel aircraft : aircrafts) {
            response.append(aircraft.getId());
            response.append(",");
            response.append(aircraft.getModel());
            response.append(",");
            response.append(aircraft.getAirline());
            if (aircrafts.indexOf(aircraft) < aircrafts.size()) response.append("\n");
        }
        return response.toString();
    }

    @Override
    public String show(int id) {
        this.aircraft = client.show(id);
        response.append(aircraft.getId());
        response.append(",");
        response.append(aircraft.getModel());
        response.append(",");
        response.append(aircraft.getAirline());
        if (aircrafts.indexOf(aircraft) < aircrafts.size()) response.append("\n");
        return response.toString();
    }

    public void add(AircraftModel aircraft) {
        client.add(aircraft);
    }

    public void edit(int id, AircraftModel update) {
        client.edit(id, update);
    }

    @Override
    public void delete(int id) {
        client.delete(id);
    }

    public String listAirports(int id) {
        for (AircraftModel aircraft : aircrafts) {
            if (aircraft.getId() == id) {
                this.airports = aircraft.getAirports();
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

    public void addAirport(int id, AirportModel airport) {
        for (AircraftModel aircraft : aircrafts) {
            if (aircraft.getId() == id) client.addAirport(id, airport);
        }
    }

    public void deleteAirport(int id, int index) {
        for (AircraftModel aircraft : aircrafts) {
            if (aircraft.getId() == id) client.deleteAirport(id, index);
        }
    }

    public String listPassengers(int id) {
        for (AircraftModel aircraft : aircrafts) {
            if (aircraft.getId() == id) {
                this.passengers = aircraft.getPassengers();
                for (PassengerModel passenger : passengers) {
                    response.append(passenger.getId());
                    response.append(",");
                    response.append(passenger.getFirst());
                    response.append(",");
                    response.append(passenger.getLast());
                    if (passengers.indexOf(passenger) < passengers.size()) response.append("\n");
                }
            }
        }
        return response.toString();
    }

    public void addPassenger(int id, PassengerModel passenger) {
        for (AircraftModel aircraft : aircrafts) {
            if (aircraft.getId() == id) client.addPassenger(id, passenger);
        }
    }

    public void deletePassenger(int id, int index) {
        for (AircraftModel aircraft : aircrafts) {
            if (aircraft.getId() == id) client.deletePassenger(id, index);
        }
    }
}
