package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.PassengerClient;

import java.util.LinkedList;
import java.util.List;

public final class PassengerCLI extends CLI {
    private PassengerClient client;
    private PassengerModel passenger;
    private List<PassengerModel> passengers;
    private LinkedList<AircraftModel> planes;
    private LinkedList<AirportModel> airports;

    public PassengerCLI() {
        super();
        this.client = new PassengerClient();
        this.passengers = client.list();
    }

    @Override
    public String list() {
        for (PassengerModel passenger : passengers) {
            response.append(passenger.getId());
            response.append(",");
            response.append(passenger.getFirst());
            response.append(",");
            response.append(passenger.getLast());
            response.append(",");
            response.append(passenger.getPhone());
            if (passengers.indexOf(passenger) != passengers.size() - 1) response.append("\n");
        }
        return response.toString();
    }

    @Override
    public String show(int id) {
        this.passenger = client.show(id);
        response.append(passenger.getId());
        response.append(",");
        response.append(passenger.getFirst());
        response.append(",");
        response.append(passenger.getLast());
        response.append(",");
        response.append(passenger.getPhone());
        return response.toString();
    }

    public void add(PassengerModel passenger) {
        client.add(passenger);
    }

    public void edit(String id, PassengerModel update) {
        client.edit(id, update);
    }

    @Override
    public void delete(int id) {
        client.delete(id);
    }

    public String listPlanes(int id) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) {
                this.planes = passenger.getPlanes();
                for (AircraftModel plane : planes) {
                    response.append(plane.getId());
                    response.append(",");
                    response.append(plane.getModel());
                    response.append(",");
                   // response.append(plane.getCode());
                    response.append("\n");
                }
            }
        }
        return response.toString();
    }

    public void addPlane(int id, AircraftModel plane) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) client.addPlane(id, plane);
        }
    }

    public void deletePlane(int id, int index) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) client.deletePlane(id, index);
        }
    }

    public String listAirports(int id) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) {
                this.airports = passenger.getAirports();
                for (AirportModel airport : airports) {
                    response.append(airport.getId());
                    response.append(",");
                    response.append(airport.getName());
                    response.append(",");
                    response.append(airport.getCode());
                    response.append("\n");
                }
            }
        }
        return response.toString();
    }

    public void addAirport(int id, AirportModel airport) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) client.addAirport(id, airport);
        }
    }

    public void deleteAirport(int id, int index) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) client.deleteAirport(id, index);
        }
    }
}
