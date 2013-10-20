package com.example.HomeTask2.entities;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/20/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */

public enum ClientType {
    SMALL("Мелкая розница",0),
    MIDDLE("Розница",1),
    BIG("Опт",2),
    VAST("Крупный опт",3);

    ClientType(String type, Integer id) {
        this.id = id;
        this.type = type;
    }

    private String type;
    private Integer id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
