package com.fmi.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataProcessing {

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String strDate = formatter.format(date);
        return strDate;
    }

    public static String dateToString(Date date) {
        return dateToString(date, "MM/dd/yyyy");
    }

}
