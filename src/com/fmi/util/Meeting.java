package com.fmi.util;

import com.fmi.datatypes.*;

import java.util.Date;

public class Meeting extends Event {

    Organisation organisation;

    public Meeting(String description, Adress adress, Date when, Contact participant, Organisation organisation) {
        super(description, adress, when, participant);
        this.organisation = organisation;
    }

    public Meeting(String description, Adress location, Date when, Contact[] participants, Organisation organisation) {
        super(description, location, when, participants);
        this.organisation = organisation;
    }
}
