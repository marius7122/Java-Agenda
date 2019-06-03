package com.fmi.util;

import java.util.Date;

public class Event {

    protected String description;
    protected String location;
    protected Date when;
    protected Contact[] participants;

    public Event(String description, String location, Date when) {
        this.description = description;
        this.location = location;
        this.when = when;
        this.participants = null;
    }

    public Event(String description, String location, Date when, Contact participant) {
        this.description = description;
        this.location = location;
        this.when = when;
        this.participants = new Contact[]{ participant };
    }

    public Event(String description, String location, Date when, Contact[] participants) {
        this.description = description;
        this.location = location;
        this.when = when;
        this.participants = participants.clone();
    }

    @Override
    public String toString() {
        return description + " at " + location;
    }

}
