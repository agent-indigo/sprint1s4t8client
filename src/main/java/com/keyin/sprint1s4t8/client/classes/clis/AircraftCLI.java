package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.clients.AircraftClient;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;

import java.util.List;

public class AircraftCLI {
    private AircraftClient aircraftClient;

    public String generateAircraftReport() {
        List<AircraftModel> aircrafts = getAircraftClient().getAllAircrafts();

        StringBuffer report = new StringBuffer();

        for (AircraftModel aircraft : aircrafts) {
            report.append(aircraft.getModel());
            report.append(" - ");
            report.append(aircraft.getAirline());
            report.append(" - ");
            report.append(aircraft.getCapacity());

            if (aircrafts.indexOf(aircraft) != (aircrafts.size() - 1)) {
                report.append(", ");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    private void listAircrafts() {
        System.out.println(getAircraftClient().getResponseFromHTTPRequest());
    }

    public AircraftClient getAircraftClient() {
        if (aircraftClient == null) {
            aircraftClient = new AircraftClient();
        }

        return aircraftClient;
    }

    public void setAircraftClient(AircraftClient aircraftClient) {
        this.aircraftClient = aircraftClient;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        AircraftCLI cliApp = new AircraftCLI();

        String serverURL = args[0];

        if (serverURL != null && !serverURL.isEmpty()) {

            AircraftClient aircraftClient = new AircraftClient();
            aircraftClient.setServerURL(serverURL);

            cliApp.setAircraftClient(aircraftClient);

            cliApp.generateAircraftReport();
        }
    }
}

