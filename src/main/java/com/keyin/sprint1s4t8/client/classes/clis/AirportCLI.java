// AirportCLI
package com.keyin.sprint1s4t8.client.classes.clis;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.AirportClient;
import java.util.LinkedList;
import java.util.List;

public final class AirportCLI extends CLI {

    private AirportClient client;
    private AirportModel airport;
    private List<AirportModel> airports;
    private LinkedList<AircraftModel> aircrafts;
    private LinkedList<PassengerModel> passengers;

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

    public String listAircrafts(int id) {

        for (AirportModel airport : airports) {

            if (airport.getId() == id) {

                this.aircrafts = airport.getAircrafts();
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

        for (AirportModel airport : airports) {

            if (airport.getId() == id) client.addAircraft(id, aircraft);

        }

    }

    public void deleteAircraft(int id, int index) {

        for (AirportModel airport : airports) {
            if (airport.getId() == id) client.deleteAircraft(id, index);

        }

    }

    public String listPassengers(int id) {

        for (AirportModel airport : airports) {
            if (airport.getId() == id) {
                this.passengers = airport.getPassengers();
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
        for (AirportModel airport : airports) {
            if (airport.getId() == id) client.addPassenger(id, passenger);

        }

    }
    public void deletePassenger(int id, int index) {
        for (AirportModel airport : airports) {
            if (airport.getId() == id) client.deletePassenger(id, index);

        }

    }

}