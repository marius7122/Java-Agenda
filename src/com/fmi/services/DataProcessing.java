package com.fmi.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataProcessing {

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String strDate = formatter.format(date);
        return strDate;
    }

    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd");
    }

    public static Date createDateFromString(String dateString, String format) {
        DateFormat sdf = new SimpleDateFormat(format);
        try {
            Date dateObject = sdf.parse(dateString);
            return dateObject;
        } catch(Exception ex) {
            System.out.println("Cannot convert " + dateString + " to date.");
            return null;
        }
    }

    public static Date createDateFromString(String dateString) {
        return createDateFromString(dateString, "yyyy-MM-dd");
    }

    public static Date today() {
        return new Date();
    }
}
