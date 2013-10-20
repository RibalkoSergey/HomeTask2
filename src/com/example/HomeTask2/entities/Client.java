package com.example.HomeTask2.entities;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/20/13
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    private String name;
    private String adress;
    private ClientType type;

    public Client(String name, String adress, ClientType type) {
        this.name = name;
        this.adress = adress;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }
}
