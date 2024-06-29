package com.keyin.sprint1s4t8.client.classes.models;
import com.keyin.sprint1s4t8.client.classes.abstracts.Model;
import com.keyin.sprint1s4t8.client.enums.ProvTerrCode;
import java.util.LinkedList;
public final class CityModel extends Model {
    private String name;
    private ProvTerrCode provTerrCode;
    private LinkedList<AirportModel> airports;
    public CityModel() {
        super();
        this.airports = new LinkedList<AirportModel>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ProvTerrCode getProvince() {
        return provTerrCode;
    }
    public void setProvince(ProvTerrCode provTerrCode) {
        this.provTerrCode = provTerrCode;
    }
    public ProvTerrCode getProvTerrCode() {
        return provTerrCode;
    }
    public void setProvTerrCode(ProvTerrCode provTerrCode) {
        this.provTerrCode = provTerrCode;
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