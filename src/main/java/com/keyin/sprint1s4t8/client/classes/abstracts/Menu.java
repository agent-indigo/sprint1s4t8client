package com.keyin.sprint1s4t8.client.classes.abstracts;
import java.util.Scanner;
import com.keyin.sprint1s4t8.client.interfaces.Selections;
public abstract class Menu implements Selections {
    protected String selectionPrompt;
    protected Scanner scanner;
    protected int selection;
    protected String invalidInputMessage;
    protected int id;
    protected int index;
    protected boolean exists;
    protected String idModel;
    protected String indexModel;
    public Menu(String idModel) {
        this.selectionPrompt = "\nEnter selection:\n";
        this.scanner = new Scanner(System.in);
        this.selection = -1;
        this.invalidInputMessage = "\nInvalid input.\n";
        this.id = -1;
        this.index = -1;
        this.exists = false;
        this.idModel = idModel;
    }
    @Override
    public final int idPrompt() {
        while (id == 1) {
            System.out.printf("\nEnter %s ID:\n", idModel);
            try {
                this.id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        return id;
    }
    @Override
    public final int indexPrompt() {
        while (index == -1) {
            System.out.printf("\nEnter %s index:\n", indexModel);
            try {
                this.index = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        return index;
    }
    @Override
    public final void setIndexModel(String indexModel) {
        this.indexModel = indexModel;
    }
    @Override
    public abstract void display();
    @Override
    public abstract void list();
    @Override
    public abstract void show();
    @Override
    public abstract void add();
    @Override
    public abstract void edit();
    @Override
    public abstract void delete();
}