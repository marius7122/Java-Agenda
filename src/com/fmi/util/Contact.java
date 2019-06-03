package com.fmi.util;

import com.fmi.datatypes.*;
import com.fmi.services.DataProcessing;
import com.fmi.services.SearchService;

import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class Contact {

    private static int lastId = 0;

    int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int adressId;
    private String organisationName;
    private TreeSet<Reminder> reminders;

    public Contact(String firstName, String lastName, String phoneNumber, int adressId, String organisationName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.adressId = adressId;
        this.organisationName = organisationName;
        this.reminders = new TreeSet<Reminder>(new Comparator<Reminder>() {
            @Override
            public int compare(Reminder r1, Reminder r2) {
                return r1.getDueDate().compareTo(r2.getDueDate());
            }
        });
        this.id = ++lastId;
    }

    public Contact(String csvLine) {
        // id, firstName, lastName, phonenumber, adressId, organisationName
        String[] vars = csvLine.split(",");

        this.id = Integer.parseInt(vars[0]);
        this.firstName = vars[1];
        this.lastName = vars[2];
        this.phoneNumber = vars[3];
        this.adressId = Integer.parseInt(vars[4]);
        this.organisationName = vars[5];

        this.reminders = new TreeSet<Reminder>(new Comparator<Reminder>() {
            @Override
            public int compare(Reminder r1, Reminder r2) {
                return r1.getDueDate().compareTo(r2.getDueDate());
            }
        });
    }

    public void addReminder(String description, Date dueDate) {
        Reminder r = new Reminder(description, dueDate, id);
        reminders.add(r);
    }

    public void addReminder(Reminder r) {
        reminders.add(r);
    }

    public void printAllReminders() {
        for(Reminder r: reminders) {
            System.out.println(r.describe());
        }
        System.out.println();
    }

    public void deleteOldReminders() {
        Date today = DataProcessing.today();

        Iterator<Reminder> iter = reminders.iterator();

        while(iter.hasNext()) {
            Reminder r = iter.next();

            // due date is in the past
            if(today.compareTo(r.getDueDate()) > 0) {
                iter.remove();
            }
        }
    }

    @Override
    public String toString() {
        String remindersStr = "";
        for(Reminder r: reminders) {
            remindersStr += r.describe() + "\n";
        }

        return firstName + " " + lastName + ":\n" + "Organisation: " + organisationName + "\n"
                + "Reminders: \n" + remindersStr;
    }

    public String toCSV() {
        return Integer.toString(id) + "," + firstName + "," + lastName + "," + phoneNumber + ","
                + Integer.toString(adressId) + "," + organisationName;
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

    public void setAdress(int adressId) {
        this.adressId = adressId;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public int getId() {
        return id;
    }

    public TreeSet<Reminder> getReminders() {
        return reminders;
    }

    public static void setLastId(int _lastId) {
        lastId = _lastId;
    }

}
