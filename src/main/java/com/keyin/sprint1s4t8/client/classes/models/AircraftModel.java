package com.keyin.sprint1s4t8.client.classes.models;
import com.keyin.sprint1s4t8.client.classes.abstracts.Model;
public final class AircraftModel extends Model {
    private String model;
    private String airline;
    private int capacity;
    public AircraftModel(
        int id,
        String model,
        String airline,
        int capacity
    ) {
        super(id);
        this.model = model;
        this.airline = airline;
        this.capacity = capacity;
    }
    public AircraftModel() {
        super();
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
}