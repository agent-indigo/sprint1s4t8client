package com.keyin.sprint1s4t8.client.classes.clis;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.AircraftClient;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import java.util.List;
public final class AircraftCLI extends CLI {
    private AircraftClient client;
    private AircraftModel plane;
    private List<AircraftModel> planes;
    public AircraftCLI() {
        super();
        this.client = new AircraftClient();
        this.planes = client.list();
    }
    @Override
    public String list() {
        for (AircraftModel plane : planes) {
            response.append(plane.getId());
            response.append(",");
            response.append(plane.getAirline());
            response.append(",");
            response.append(plane.getModel());
            response.append(",");
            response.append(plane.getCapacity());
            if (planes.indexOf(plane) != planes.size() - 1) response.append("\n");
        }
        return response.toString();
    }
    @Override
    public String show(String id) {
        this.plane = client.show(id);
        response.append(plane.getId());
        response.append(",");
        response.append(plane.getAirline());
        response.append(",");
        response.append(plane.getModel());
        response.append(",");
        response.append(plane.getCapacity());
        return response.toString();
    }
    public void add(AircraftModel aircraft) {
        client.add(aircraft);
    }
    public void edit(String id, AircraftModel update) {
        client.edit(id, update);
    }
    @Override
    public void delete(String id) {
        client.delete(id);
    }
}