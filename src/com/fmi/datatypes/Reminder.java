package com.fmi.datatypes;

import com.fmi.services.DataProcessing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reminder implements DataFormat{

    private String description;
    private Date dueDate;

    public Reminder(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    public String describe() {
        return DataProcessing.dateToString(dueDate);
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
}
