package com.example.kryguu.application;

public class Client {
    private long id;
    public String name;
    public String surname;
    public String PESEL;

    public Client(String name, String surname, String PESEL) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
    }

    public long getId() {
        return id;
    }
}
