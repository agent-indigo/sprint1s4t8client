package com.keyin.sprint1s4t8.client.classes.abstracts;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.interfaces.IdAccess;
public abstract class Model implements IdAccess {
    protected int id;
    public Model(int id) {
        this.id = id;
    }
    public Model() {}
    @Override
    public final int getId() {
        return id;
    }
    @Override
    public final void setId(int id) {
        this.id = id;
    }

    public abstract AircraftModel[] getAircrafts();

    public abstract AirportModel[] getAirports();
}