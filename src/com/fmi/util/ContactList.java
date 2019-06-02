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

    // add a contact
    public void add(Contact c) {
        contacts.add(c);
    }

    // delete a contact
    public void delete(Contact c) {
        if(c == null)
            return;

        for(Contact aux: contacts) {
            if(c.equals(aux))
                contacts.remove(c);
        }
    }

    // search by first or last name
    public Contact findAproximationMatch(String name) {
        for(Contact c : contacts) {
            String firstName = c.getFirstName();
            String lastName = c.getLastName();

            // match found
            if(firstName.startsWith(name) || firstName.endsWith(name) ||
                lastName.startsWith(name) || lastName.endsWith(name)) {
                return c;
            }
        }

        return null;
    }

    // search by first and last name
    public Contact findExactMatch(String firstName, String lastName) {
        for(Contact c : contacts) {
            if(c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                return c;
            }
        }
        return null;
    }

}
