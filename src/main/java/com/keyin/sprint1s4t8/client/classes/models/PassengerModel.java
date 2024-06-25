package com.keyin.sprint1s4t8.client.classes.models;
import com.keyin.sprint1s4t8.client.classes.abstracts.Model;
public final class PassengerModel extends Model {
    private String first;
    private String last;
    private String phone;
    private CityModel city;
    public PassengerModel(
        int id,
        String first,
        String last,
        String phone,
        CityModel city
    ) {
        super(id);
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.city = city;
    }
    public PassengerModel() {
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
}