package com.fmi.datatypes;

public class Adress implements DataFormat{

    private static int lastId = 0;

    private int id;
    private String country;
    private String city;
    private String street;
    private String postalCode;

    public Adress(String country, String city, String street, String postalCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.id = ++lastId;
    }

    private Adress(String country, String city, String street, String postalCode, int id) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.id = id;
    }

    public Adress(String csvLine) {
        // id, country, city, street, postalCode
        String[] variabiles = csvLine.split(",");

        this.id = Integer.parseInt(variabiles[0]);
        this.country = variabiles[1];
        this.city = variabiles[2];
        this.street = variabiles[3];
        this.postalCode = variabiles[4];
    }

    public String describe() {
        return country + ", " + city + ", str. "+ street;
    }

    public static void setLastId(int _lastId) {
        lastId = _lastId;
    }

    public int getId() {
        return id;
    }

    public String toCSV() {
        return Integer.toString(id) + "," + country + "," + city + "," + street + "," + postalCode;
    }
}

