//AircraftCLI
package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.AircraftClient;

import java.util.List;

public final class AircraftCLI extends CLI {
    private AircraftClient client;
    private AircraftModel aircraft;
    private List<AircraftModel> aircrafts;

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
            response.append(",");
            response.append(aircraft.getCapacity());
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
        response.append(",");
        response.append(aircraft.getCapacity());
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
}