package com.fmi.services;

import com.fmi.datatypes.Adress;
import com.fmi.util.Contact;

import java.util.ArrayList;

public class SearchService {

    public static Contact searchContact(ArrayList<Contact> list, int contactId) {
        for(Contact c: list) {
            if(c.getId() == contactId)
                return c;
        }
        return null;
    }

    public static Adress searchAdress(ArrayList<Adress> list, int adressId) {
        for(Adress a: list) {
            if(a.getId() == adressId)
                return a;
        }
        return null;
    }
}
