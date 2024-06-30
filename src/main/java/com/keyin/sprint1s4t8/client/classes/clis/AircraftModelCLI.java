//AircraftModelCLI
package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.AircraftModelClient;

import java.util.List;

public final class AircraftModelCLI extends CLI {
    private AircraftModelClient client;
    private AircraftModel aircraft;
    private List<AircraftModel> aircrafts;

    public AircraftModelCLI() {
        super();
        this.client = new AircraftModelClient();
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