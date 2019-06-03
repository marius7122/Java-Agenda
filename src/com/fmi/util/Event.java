package com.fmi.util;

import com.fmi.datatypes.Adress;
import com.fmi.services.DataProcessing;

import java.util.Date;

public class Event {

    protected String description;
    protected Adress adress;
    protected Date when;
    protected Contact[] participants;

    public Event(String description, Adress adress, Date when) {
        this.description = description;
        this.adress = adress;
        this.when = when;
        this.participants = null;
    }

    public Event(String description, Adress adress, Date when, Contact participant) {
        this.description = description;
        this.adress = adress;
        this.when = when;
        this.participants = new Contact[]{ participant };
    }

    public Event(String description, Adress adress, Date when, Contact[] participants) {
        this.description = description;
        this.adress = adress;
        this.when = when;
        this.participants = participants.clone();
    }

    @Override
    public String toString() {
        return description + " at " + adress.describe();
    }

    // the meeting was in the past
    public boolean isOld() {
        return (DataProcessing.today().compareTo(when) > 0);
    }

    public Date getDate() {
        return when;
    }

}
