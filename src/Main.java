import com.fmi.datatypes.Adress;
import com.fmi.datatypes.Organisation;
import com.fmi.datatypes.Reminder;
import com.fmi.services.DataProcessing;
import com.fmi.services.DeserializeService;
import com.fmi.services.FileService;
import com.fmi.services.SearchService;
import com.fmi.util.Contact;
import com.fmi.util.ContactList;
import com.fmi.util.Event;
import com.fmi.util.Meeting;

import javax.xml.stream.Location;
import java.nio.file.Files;
import java.util.*;

public class Main {

    public static Scanner in;

    public static void main(String[] args) {

        in = new Scanner(System.in);

        // input files
        final String adressesPath = "adresses.csv";
        final String organisationsPath = "organisations.csv";
        final String contactsPath = "contacts.csv";
        final String remindersPath = "reminders.csv";


        // load data
        ArrayList<Adress> adresses = DeserializeService.deserializeAdresses(adressesPath);
        ArrayList<Organisation> organisations = DeserializeService.deserializeOrganisations(organisationsPath);
        ArrayList<Contact> contacts = DeserializeService.deserializeContacts(contactsPath);
        ArrayList<Reminder> reminders = DeserializeService.deserializeReminders(remindersPath);

        // set lastId's
        Adress.setLastId(adresses.get(adresses.size() - 1).getId());
        Contact.setLastId(contacts.get(contacts.size() - 1).getId());
        Reminder.setLastId(reminders.get(reminders.size() - 1).getId());

        // append reminders to contacts
        for(Reminder r: reminders) {
            SearchService.searchContact(contacts, r.getContactId()).addReminder(r);
        }


        /*
        // add some locations
        Adress a1 = new Adress("Romania", "Bucuresti", "Matasari", "101");
        Adress a2 = new Adress("Romania", "Constanta", "Veseliei", "102");
        Adress a3 = new Adress("Romania", "Bucuresti", "bd. Unirii", "103");
        Adress a4 = new Adress("SUA", "Washington", "Johnson", "104");
        FileService.appendLineToFile(adressesPath, a1.toCSV());
        FileService.appendLineToFile(adressesPath, a2.toCSV());
        FileService.appendLineToFile(adressesPath, a3.toCSV());
        FileService.appendLineToFile(adressesPath, a4.toCSV());

        // add some Organisations
        Organisation o1 = new Organisation("FMI", 3);
        Organisation o2 = new Organisation("FBI", 4);
        FileService.appendLineToFile(organisationsPath, o1.toCSV());
        FileService.appendLineToFile(organisationsPath, o2.toCSV());

        // add some Contacts
        Contact c1 = new Contact("Marian", "Ciltea", "0728875025", 1, "FMI");
        Contact c2 = new Contact("Ion", "Paraschivescu", "0725123584", 3, "FBI");
        Contact c3 = new Contact("Anca", "Alumariei", "0726584356", 2, "FBI");
        FileService.appendLineToFile(contactsPath, c1.toCSV());
        FileService.appendLineToFile(contactsPath, c2.toCSV());
        FileService.appendLineToFile(contactsPath, c3.toCSV());

        // add some reminders
        c1.addReminder("do task 1", DataProcessing.createDateFromString("2019-6-5"));
        c1.addReminder("do task 2", DataProcessing.createDateFromString("2019-7-5"));
        c1.addReminder("do task 3", DataProcessing.createDateFromString("2019-6-10"));
        c1.addReminder("do task 4", DataProcessing.createDateFromString("2019-6-7"));
        for(Reminder r: c1.getReminders()) {
            FileService.appendLineToFile(remindersPath, r.toCSV());
        }
        */


        for(Contact c: contacts) {
            System.out.println(c.toString());
        }

    }


}
