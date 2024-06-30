
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
    private LinkedList<AircraftModel> aircrafts;
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
            if (passengers.indexOf(passenger) < passengers.size()) response.append("\n");
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
        if (passengers.indexOf(passenger) < passengers.size()) response.append("\n");
        return response.toString();
    }
    public void add(PassengerModel passenger) {
        client.add(passenger);
    }
    public void edit(int id, PassengerModel update) {
        client.edit(id, update);
    }

    @Override
    public void delete(int id) {
        client.delete(id);
    }

    public String listAircrafts(int id) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) {
                this.aircrafts = passenger.getAircrafts();
                for (AircraftModel aircraft : aircrafts) {
                    response.append(aircraft.getId());
                    response.append(",");
                    response.append(aircraft.getModel());
                    response.append(",");
                    response.append(aircraft.getAirline());
                    if (aircrafts.indexOf(aircraft) < aircrafts.size()) response.append("\n");
                }
            }
        }

        return response.toString();
    }
    public void addAircraft(int id, AircraftModel aircraft) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) client.addAircraft(id, aircraft);
        }
    }

    public void deleteAircraft(int id, int index) {
        for (PassengerModel passenger : passengers) {
            if (passenger.getId() == id) client.deleteAircraft(id, index);
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
                    if (airports.indexOf(airport) < airports.size()) response.append("\n");
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