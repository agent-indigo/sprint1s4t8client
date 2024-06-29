package com.keyin.sprint1s4t8.client.classes.models;
import com.keyin.sprint1s4t8.client.classes.abstracts.Model;
import java.util.LinkedList;
public final class AircraftModel extends Model {
    private String model;
    private String airline;
    private int capacity;
    private LinkedList<AirportModel> airports;
    private LinkedList<PassengerModel> passengers;
    public AircraftModel() {
        super();
        this.airports = new LinkedList<AirportModel>();
        this.passengers = new LinkedList<PassengerModel>();
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public LinkedList<PassengerModel> getPassengers() {
        return passengers;
    }
    public void addPassenger(PassengerModel passenger) {
        passengers.addLast(passenger);
    }
    public void deletePassenger(int index) {
        passengers.remove(index);
    }
    public LinkedList<AirportModel> getAirports() {
        return airports;
    }
    public void addAirport(AirportModel airport) {
        airports.addLast(airport);
    }
    public void deleteAirport(int index) {
        airports.remove(index);
    }


}