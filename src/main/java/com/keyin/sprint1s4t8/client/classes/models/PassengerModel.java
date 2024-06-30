package com.keyin.sprint1s4t8.client.classes.models;
import java.util.LinkedList;
import com.keyin.sprint1s4t8.client.classes.abstracts.Model;
public final class PassengerModel extends Model {
    private String first;
    private String last;
    private String phone;
    private CityModel city;
    private LinkedList<AircraftModel> planes;
    private LinkedList<AirportModel> airports;
    public PassengerModel() {
        super();
        this.planes = new LinkedList<AircraftModel>();
        this.airports = new LinkedList<AirportModel>();
    }
    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
    public void deletePlane(int id) {
        planes.remove(id);
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

    public LinkedList<AircraftModel> getAircrafts() {
        return null;
    }
}