package com.fmi.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataProcessing {

    public static String dateToString(Date date, String pattern) {
        AuditService.log("dateToString");

        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String strDate = formatter.format(date);
        return strDate;
    }

    public static String dateToString(Date date) {
        AuditService.log("dateToString");

        return dateToString(date, "yyyy-MM-dd");
    }

    public static Date createDateFromString(String dateString, String format) {
        AuditService.log("createDateFromString");

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
        AuditService.log("createDateFromString");

        return createDateFromString(dateString, "yyyy-MM-dd");
    }

    public static Date today() {
        return new Date();
    }

    public static Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
