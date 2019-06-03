package com.fmi.services;


import com.fmi.datatypes.Adress;
import com.fmi.datatypes.Organisation;
import com.fmi.datatypes.Reminder;
import com.fmi.util.Contact;

import java.util.ArrayList;

public class DeserializeService {

    public static ArrayList<Adress> deserializeAdresses(String path) {
        ArrayList<Adress> adresses = new ArrayList<>();
        ArrayList<String> lines = FileService.readLinesFromFile(path);

        for(String line: lines) {
            adresses.add(new Adress(line));
        }

        return adresses;
    }

    public static ArrayList<Organisation> deserializeOrganisations(String path) {
        ArrayList<Organisation> organisations = new ArrayList<>();
        ArrayList<String> lines = FileService.readLinesFromFile(path);

        for(String line: lines) {
            organisations.add(new Organisation(line));
        }

        return organisations;
    }


    public static ArrayList<Contact> deserializeContacts(String path) {
        ArrayList<Contact> contacts = new ArrayList<>();
        ArrayList<String> lines = FileService.readLinesFromFile(path);

        for(String line: lines) {
            contacts.add(new Contact(line));
        }

        return contacts;
    }

    public static ArrayList<Reminder> deserializeReminders(String path) {
        ArrayList<Reminder> reminders = new ArrayList<>();
        ArrayList<String> lines = FileService.readLinesFromFile(path);

        for(String line: lines) {
            reminders.add(new Reminder(line));
        }

        return reminders;
    }
}
