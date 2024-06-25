

package com.keyin.sprint1s4t8.client.classes.clis;
import com.keyin.sprint1s4t8.client.classes.models.CityModel;
import com.keyin.sprint1s4t8.client.classes.abstracts.CLI;
import com.keyin.sprint1s4t8.client.classes.clients.CityClient;
import java.util.List;
public final class CityCLI extends CLI {
    private CityClient client;
    private CityModel city;
    private List<CityModel> cities;
    public CityCLI() {
        super();
        this.client = new CityClient();
        this.cities = client.list();
    }
    @Override
    public String list() {
        for (CityModel city : cities) {
            response.append(city.getId());
            response.append(",");
            response.append(city.getName());
            response.append(",");
            response.append(city.getProvince());
            if (cities.indexOf(city) != cities.size() - 1) response.append("\n");
        }
        return response.toString();
    }
    @Override
    public String show(String id) {
        this.city = client.show(id);
        response.append(city.getId());
        response.append(",");
        response.append(city.getName());
        response.append(",");
        response.append(city.getProvince());
        return response.toString();
    }
    public void add(CityModel city) {
        client.add(city);
    }
    public void edit(String id, CityModel update) {
        client.edit(id, update);
    }
    @Override
    public void delete(String id) {
        client.delete(id);
    }
}

