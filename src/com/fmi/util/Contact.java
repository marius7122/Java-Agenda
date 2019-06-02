package com.fmi.util;

import com.fmi.datatypes.*;

import java.util.Comparator;
import java.util.TreeSet;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Adress adress;
    private Organisation organisation;
    private TreeSet<Reminder> reminders;

    public Contact(String firstName, String lastName, String phoneNumber, Adress adress, Organisation organisation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.organisation = organisation;
        this.reminders = new TreeSet<Reminder>(new Comparator<Reminder>() {
            @Override
            public int compare(Reminder r1, Reminder r2) {
                return r1.getDueDate().compareTo(r2.getDueDate());
            }
        });
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

}
