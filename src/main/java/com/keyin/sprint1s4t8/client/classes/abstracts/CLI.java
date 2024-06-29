package com.keyin.sprint1s4t8.client.classes.abstracts;
import com.keyin.sprint1s4t8.client.interfaces.Commands;
public abstract class CLI implements Commands {
    protected StringBuffer response;
    public CLI() {
        this.response = new StringBuffer();
    }
    @Override
    public abstract String list();
    @Override
    public abstract String show(int id);
    @Override
    public abstract void delete(int id);
}