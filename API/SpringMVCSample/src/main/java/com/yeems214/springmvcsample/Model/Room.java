package com.yeems214.springmvcsample.Model;

public class Room {
    private long id;
    private String name;
    private String number;
    private String info;

    public Room() {
        super();
    }

    public Room(long id, String name, String number, String info) {
        super();
        this.id = id;
        this.name = name;
        this.number = number;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getInfo() {
        return info;
    }

    public void setId(long id) {
        this.id = id;
    }

}
