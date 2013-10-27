package com.example.HomeTask2.entities;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/27/13
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tablet implements Serializable {
    private int id;
    private String name;
    private String fullName;
    private String description;
    private float price;

    public Tablet(int id, String name, String fullName, String description, float price) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
