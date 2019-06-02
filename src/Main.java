import com.fmi.datatypes.Adress;
import com.fmi.datatypes.Organisation;
import com.fmi.services.DataProcessing;
import com.fmi.util.Contact;
import com.fmi.util.ContactList;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // organisations
        Organisation FMI = new Organisation("FMI", new Adress("Romania",
                "Bucuresti", "Bd. Unirii"));
        Organisation SRI = new Organisation("SRI", new Adress("Romania",
                "Bucurest", "Primaverii"));
        Organisation FBI = new Organisation("FBI", new Adress("America",
                "Washington", "Thompson"));

        // contact list
        ContactList contacts = new ContactList();

        contacts.add(new Contact("Marian", "Ciltea", "0728879015",
                new Adress("Romania", "Ilfov", "M.E."), FMI));
        contacts.add(new Contact("Ion", "Parvu", "0758123582",
                new Adress("Romania", "Bucuresti", "Ion Creanga"), FBI));
        contacts.add(new Contact("Anca", "Amariei", "0728879054",
                new Adress("Romania", "Constanta", "Fericirii"), SRI));

        // contact test
        System.out.println("Contact test");
        contacts.printAllContacts();
        contacts.delete(contacts.findAproximationMatch("Ion"));
        contacts.printAllContacts();
        contacts.add(new Contact("Ion", "Parvu", "0758123582",
                new Adress("Romania", "Bucuresti", "Ion Creanga"), FBI));
        contacts.printAllContacts();
        contacts.delete(contacts.findExactMatch("Marian", "Ciltea"));
        contacts.printAllContacts();


        // create reminders
        Contact c = contacts.getIndex(0);
        c.addReminder("do task 1",
                DataProcessing.createDateFromString("2019-10-2"));
        c.addReminder("do task 2",
                DataProcessing.createDateFromString("2019-10-5"));
        c.addReminder("do task 3",
                DataProcessing.createDateFromString("2019-10-4"));
        c.addReminder("do task 4",
                DataProcessing.createDateFromString("2019-10-1"));
        c.addReminder("do task 5",
                DataProcessing.createDateFromString("2019-10-10"));
        c.addReminder("do task 6",
                DataProcessing.createDateFromString("2019-10-7"));
        c.addReminder("do task 7",
                DataProcessing.createDateFromString("2019-10-3"));

        // reminders test
        System.out.println("reminders test:");
        c.printAllReminders();


    }
}
