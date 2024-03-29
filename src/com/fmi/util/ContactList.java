package com.fmi.util;

import com.fmi.services.AuditService;

import java.util.ArrayList;

public class ContactList {

    private ArrayList<Contact> contacts;

    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    public ContactList(ArrayList<Contact> contacts) {
        this.contacts = new ArrayList<>(contacts);
    }

    public ContactList(ContactList contacts) {
        this.contacts = new ArrayList<>(contacts.contacts);
    }

    // add a contact
    public void add(Contact c) {
        AuditService.log("ContactList.add");
        contacts.add(c);
    }

    // delete a contact
    public void delete(Contact c) {
        AuditService.log("ContactList.delete");

        if(c == null)
            return;

        for(Contact aux: contacts) {
            if(aux.equals(c)) {
                contacts.remove(c);
                break;
            }
        }
    }

    // search by first or last name
    public Contact findAproximationMatch(String name) {
        AuditService.log("ContactList.findAproximationMatch");

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
        AuditService.log("ContactList.findExactMatch");

        for(Contact c : contacts) {
            if(c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                return c;
            }
        }
        return null;
    }

    // return contact at index
    public Contact getIndex(int index) {
        return contacts.get(index);
    }

    // print all contacts
    public void printAllContacts() {
        AuditService.log("ContactList.printAll");

        for(Contact c: contacts) {
            System.out.println(c.toString());
        }
        System.out.println();
    }
}
