package com.keyin.sprint1s4t8.client.classes.menus;
import com.keyin.sprint1s4t8.client.classes.abstracts.Menu;
import com.keyin.sprint1s4t8.client.classes.clis.CityCLI;
import com.keyin.sprint1s4t8.client.classes.models.AirportModel;
import com.keyin.sprint1s4t8.client.classes.models.CityModel;
import com.keyin.sprint1s4t8.client.enums.ProvTerrCode;
public final class CityMenu extends Menu {
    private CityCLI cli;
    private CityModel city;
    private AirportModel airport;
    public CityMenu() {
        super("city");
        this.cli = new CityCLI();
        this.city = new CityModel();
        this.airport = new AirportModel();
    }
    private CityModel setupCity() {
        city.setId(id);
        System.out.println("\nEnter city name:\n");
        city.setName(scanner.nextLine());
        while (selection != 0) {
            System.out.println("\nEnter Province/Territory:\n");
            System.out.println("1: AB");
            System.out.println("2: BC");
            System.out.println("3: MB");
            System.out.println("4: NB");
            System.out.println("5: NL");
            System.out.println("6: NS");
            System.out.println("7: NT");
            System.out.println("8: NU");
            System.out.println("9: ON");
            System.out.println("10: PE");
            System.out.println("11: QC");
            System.out.println("12: SK");
            System.out.println("13: YT");
            System.out.println(selectionPrompt);
            try {
                this.selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.AB);
                        break;
                    } case 2: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.BC);
                        break;
                    } case 3: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.MB);
                        break;
                    } case 4: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.NB);
                        break;
                    } case 5: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.NL);
                        break;
                    } case 6: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.NS);
                        break;
                    } case 7: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.NT);
                        break;
                    } case 8: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.NU);
                        break;
                    } case 9: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.ON);
                        break;
                    } case 10: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.PE);
                        break;
                    } case 11: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.QC);
                        break;
                    } case 12: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.SK);
                        break;
                    } case 13: {
                        this.selection = 0;
                        city.setProvTerrCode(ProvTerrCode.YT);
                        break;
                    } default: {
                        this.selection = -1;
                        System.err.println(invalidInputMessage);
                        break;
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println(invalidInputMessage);
            }
        }
        this.selection = -1;
        return city;
    }
    @Override
    public void display() {
        while (selection != 9) {
            System.out.println("\nCities\n");
            System.out.println("1: List cities");
            System.out.println("2: View a city");
            System.out.println("3: Add a city");
            System.out.println("4: Edit a city");
            System.out.println("5: Delete a city");
            System.out.println("6: List a city's airports");
            System.out.println("7: Add an airport to a city");
            System.out.println("8: Delete an airport from a city");
            System.out.println("9: Main menu");
            try {
                this.selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1: {
                        this.selection = -1;
                        list();
                        break;
                    } case 2: {
                        this.selection = -1;
                        show();
                        break;
                    } case 3: {
                        this.selection = -1;
                        add();
                        break;
                    } case 4: {
                        this.selection = -1;
                        edit();
                        break;
                    } case 5: {
                        this.selection = -1;
                        delete();
                        break;
                    } case 6: {
                        this.selection = -1;
                        listAirports();
                        break;
                    } case 7: {
                        this.selection = -1;
                        addAirport();
                        break;
                    } case 8: {
                        this.selection = -1;
                        deleteAirport();
                        break;
                    } case 9: {
                        this.selection = -1;
                        break;
                    } default: {
                        this.selection = -1;
                        System.err.println(invalidInputMessage);
                        break;
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println(invalidInputMessage);
            }
        }
    }
    @Override
    public void list() {
        cli.list();
    }
    @Override
    public void show() {
        cli.show(idPrompt());
    }
    @Override
    public void add() {
        idPrompt();
        cli.add(setupCity());
    }
    @Override
    public void edit() {
        cli.edit(idPrompt(), setupCity());
    }
    @Override
    public void delete() {
        cli.delete(idPrompt());
    }
    public void listAirports() {
        cli.listAirports(idPrompt());
    }
    public void addAirport() {
        setIndexModel("airport");
        System.out.println("\nEnter airport name:\n");
        airport.setName(scanner.nextLine());
        System.out.println("\nEnter airport code:\n");
        airport.setCode(scanner.nextLine());
        System.out.println("\nEnter airport city details:\n");
        airport.setCity(setupCity());
        cli.addAirport(idPrompt(), airport);
    }
    public void deleteAirport() {
        setIndexModel("airport");
        cli.deleteAirport(idPrompt(), indexPrompt());
    }
}