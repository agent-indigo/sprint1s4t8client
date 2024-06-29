package com.keyin.sprint1s4t8.client.classes;

import com.keyin.sprint1s4t8.client.classes.clis.CityCLI;
import com.keyin.sprint1s4t8.client.classes.clis.PassengerCLI;
import com.keyin.sprint1s4t8.client.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.CityModel;
import com.keyin.sprint1s4t8.client.classes.models.PassengerModel;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CityCLI cityCLI = new CityCLI();
        PassengerCLI passengerCLI = new PassengerCLI();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. List all cities");
            System.out.println("2. List all aircraft a passenger has traveled on");
            System.out.println("3. List all airports an aircraft can take off from and land at");
            System.out.println("4. List all airports a passenger has used");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println(cityCLI.list());
                    break;
                case 2:
                    System.out.print("Enter passenger ID: ");
                    int passengerId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println(passengerCLI.listPlanes(passengerId));
                    break;
                case 3:
                    System.out.println("Option 3: Not implemented yet");
                    break;
                case 4:
                    System.out.println("Option 4: Not implemented yet");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
