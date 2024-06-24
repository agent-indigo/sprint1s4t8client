package com.keyin.sprint1s4t8.client.classes.clients;

import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;

import java.util.List;

public class ObjectMapper {
    public void disable(Object failOnUnknownProperties) {
    }

    public List<AircraftModel> readValue(String response, TypeReference<List<AircraftModel>> typeReference) {
        return List.of();
    }
}
