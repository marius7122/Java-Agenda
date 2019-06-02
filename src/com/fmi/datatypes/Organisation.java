package com.fmi.datatypes;

public class Organisation implements DataFormat {

    private String name;
    private Adress adress;

    public Organisation(String name, Adress adress) {
        this.name = name;
        this.adress = adress;
    }

    public String describe() {
        return name;
    }
}
