package com.fmi.datatypes;

public class Organisation implements DataFormat {

    private String name;    // used as identifier
    private int adressId;

    public Organisation(String name, int adressId) {
        this.name = name;
        this.adressId = adressId;
    }

    public Organisation(String csvLine) {
        // name, adressId
        String[] variabiles = csvLine.split(",");
        this.name = variabiles[0];
        this.adressId = Integer.parseInt(variabiles[1]);
    }

    public String describe() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String toCSV() {
        return name + "," + adressId;
    }
}
