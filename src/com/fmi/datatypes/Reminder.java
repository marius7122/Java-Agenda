package com.fmi.datatypes;

import com.fmi.services.DataProcessing;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reminder implements DataFormat{

    private static int lastId = 0;

    private int id;
    private String description;
    private Date dueDate;
    int contactId;

    public Reminder(String description, Date dueDate, int contactId) {
        this.description = description;
        this.dueDate = dueDate;
        this.id = ++lastId;
        this.contactId = contactId;
    }

    public Reminder(String csvLine) {
        // id, description, dueDate, contactId
        String[] variabiles = csvLine.split(",");

        this.id = Integer.parseInt(variabiles[0]);
        this.description = variabiles[1];
        this.dueDate = DataProcessing.createDateFromString(variabiles[2]);
        this.contactId = Integer.parseInt(variabiles[3]);
    }

    public String describe() {
        return DataProcessing.dateToString(dueDate) + ": " + description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public static void setLastId(int _lastId) {
        lastId = _lastId;
    }

    public int getId() {
        return id;
    }

    public String toCSV() {
        return Integer.toString(id) + "," + description + "," + DataProcessing.dateToString(dueDate)
                + "," + Integer.toString(contactId);
    }
}
