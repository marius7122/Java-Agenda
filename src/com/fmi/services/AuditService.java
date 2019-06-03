package com.fmi.services;


public class AuditService {

    private static final String auditFile = "audit.csv";

    public static void log(String info) {
        String line = info + ", " + DataProcessing.currentTimestamp().toString();
        FileService.appendLineToFile(auditFile, line);
    }
}
