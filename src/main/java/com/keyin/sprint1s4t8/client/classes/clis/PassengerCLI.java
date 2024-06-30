
package com.keyin.sprint1s4t8.client.classes.clis;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.PassengerClient;

import java.util.List;
public final class PassengerCLI extends CLI {
    private PassengerClient client;
    private PassengerModel passenger;
    private List<PassengerModel> passengers;
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
            response.append(",");
            response.append(passenger.getPhone());
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
        response.append(",");
        response.append(passenger.getPhone());
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
}