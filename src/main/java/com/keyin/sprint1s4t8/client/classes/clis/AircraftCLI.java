

package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.clients.AircraftClient;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;

import java.util.List;

public class AircraftCLI {
    private AircraftClient aircraftClient;

    public String generateAircraftReport() {
        List<AircraftModel> aircrafts = getAircraftClient().getAllAircrafts();

        StringBuilder report = new StringBuilder();

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

    private void listAirportsInCities() {
        List<AirportModel> airports = getAircraftClient().getAllAirports();

        for (AirportModel airport : airports) {
            System.out.println("Airport: " + airport.getName() + " is in City: " + airport.getCity().getName());
        }
    }

    private void listAircraftPassengers() {
        List<PassengerModel> passengers = getAircraftClient().getAllPassengers();

        for (PassengerModel passenger : passengers) {
            System.out.println("Passenger: " + passenger.getFirst() + " " + passenger.getLast() + " has traveled on:");
            for (AircraftModel aircraft : passenger.getAircrafts()) {
                System.out.println("    Aircraft: " + aircraft.getModel() + " (" + aircraft.getAirline() + ")");
            }
        }
    }

    private void listAircraftTakeOffAndLand() {
        List<AircraftModel> aircrafts = getAircraftClient().getAllAircrafts();

        for (AircraftModel aircraft : aircrafts) {
            System.out.println("Aircraft: " + aircraft.getModel() + " (" + aircraft.getAirline() + ") can take off and land at:");
            for (AirportModel airport : aircraft.getAirports()) {
                System.out.println("    Airport: " + airport.getName());
            }
        }
    }

    private void listPassengerUsedAirports() {
        List<PassengerModel> passengers = getAircraftClient().getAllPassengers();

        for (PassengerModel passenger : passengers) {
            System.out.println("Passenger: " + passenger.getFirst() + " " + passenger.getLast() + " has used airports:");
            for (AirportModel airport : passenger.getAirports()) {
                System.out.println("    Airport: " + airport.getName());
            }
        }
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
        if (args.length < 1) {
            System.err.println("Please enter a URL and an option (1-4).");
            System.exit(1);
        }

        String serverURL = args[0];
        //String option = args[1];

        AircraftCLI cliApp = new AircraftCLI();
        cliApp.getAircraftClient().setServerURL(serverURL);
        cliApp.generateAircraftReport();

//        if (serverURL != null && !serverURL.isEmpty()) {
//            AircraftClient aircraftClient = new AircraftClient();
//            aircraftClient.setServerURL(serverURL);
//
//            cliApp.setAircraftClient(aircraftClient);
//
//            switch (option) {
//                case "1":
//                    cliApp.listAirportsInCities();
//                    break;
//                case "2":
//                    cliApp.listAircraftPassengers();
//                    break;
//                case "3":
//                    cliApp.listAircraftTakeOffAndLand();
//                    break;
//                case "4":
//                    cliApp.listPassengerUsedAirports();
//                    break;
//                default:
//                    System.err.println("Invalid option provided. Please enter a number between 1 and 4.");
//                    System.exit(1);
//            }
//        } else {
//            System.err.println("Invalid server URL provided.");
//            System.exit(1);
//        }
//    }
    }
}

