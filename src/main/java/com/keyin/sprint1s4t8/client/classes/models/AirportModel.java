package com.keyin.sprint1s4t8.client.classes.models;
import com.keyin.sprint1s4t8.client.classes.abstracts.Model;
import java.util.LinkedList;
public final class AirportModel extends Model {
    private String name;
    private String code;
    private CityModel city;
    private LinkedList<AircraftModel> planes;
    private LinkedList<PassengerModel> passengers;
    public AirportModel() {
        super();
        this.planes = new LinkedList<AircraftModel>();
        this.passengers = new LinkedList<PassengerModel>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public CityModel getCity() {
        return city;
    }
    public void setCity(CityModel city) {
        this.city = city;
    }
    public LinkedList<AircraftModel> getPlanes() {
        return planes;
    }
    public void addPlane(AircraftModel plane) {
        planes.addLast(plane);
    }
    public void deletePlane(int index) {
        planes.remove(index);
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
}