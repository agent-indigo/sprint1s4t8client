package com.keyin.sprint1s4t8.client.classes.models;
import com.keyin.sprint1s4t8.client.classes.abstracts.Model;
import com.keyin.sprint1s4t8.client.enums.ProvTerrCode;
public final class CityModel extends Model {
    private String name;
    private ProvTerrCode provTerrCode;
    public CityModel(
        int id,
        String name,
        ProvTerrCode provTerrCode
    ) {
        super(id);
        this.name = name;
        this.provTerrCode = provTerrCode;
    }
    public CityModel() {
        super();
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
}