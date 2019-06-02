package com.fmi.datatypes;

public class Adress implements DataFormat{

    private String country;
    private String city;
    private String street;

    public Adress(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String describe() {
        return country + city + street;
    }

}

