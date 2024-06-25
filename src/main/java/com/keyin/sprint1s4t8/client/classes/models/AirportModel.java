package com.keyin.sprint1s4t8.client.classes.models;
import com.keyin.sprint1s4t8.client.classes.abstracts.Model;
public final class AirportModel extends Model {
    private String name;
    private String code;
    private CityModel city;
    public AirportModel(
        int id,
        String name,
        String code,
        CityModel city
    ) {
        super(id);
        this.name = name;
        this.code = code;
        this.city = city;
    }
    public AirportModel() {
        super();
    }

    /**
     * @return
     */
    @Override
    public AircraftModel[] getAircrafts() {
        return new AircraftModel[0];
    }

    /**
     * @return
     */
    @Override
    public AirportModel[] getAirports() {
        return new AirportModel[0];
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
}