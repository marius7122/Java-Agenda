package com.fmi.util;

import java.util.ArrayList;

public class ContactList {

    private ArrayList<Contact> contacts;

    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    public ContactList(ArrayList<Contact> contacts) {
        this.contacts = new ArrayList<>(contacts);
    }
}
