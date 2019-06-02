import com.fmi.datatypes.Adress;
import com.fmi.datatypes.Organisation;
import com.fmi.services.DataProcessing;
import com.fmi.util.Contact;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Organisation FMI = new Organisation("FMI", new Adress("Romania",
                "Bucuresti", "Bd. Unirii"));

        Contact c = new Contact("Marian", "Ciltea", "0728879015",
                new Adress("Romania", "Ilfov", "M.E."), FMI);

        c.addReminder("give him money 1", DataProcessing.createDateFromString("2019-10-2"));
        c.addReminder("give him money 2", DataProcessing.createDateFromString("2019-10-5"));
        c.addReminder("give him money 3", DataProcessing.createDateFromString("2019-10-4"));
        c.addReminder("give him money 4", DataProcessing.createDateFromString("2019-10-1"));
        c.addReminder("give him money 5", DataProcessing.createDateFromString("2019-10-10"));
        c.addReminder("give him money 6", DataProcessing.createDateFromString("2019-10-7"));
        c.addReminder("give him money 7", DataProcessing.createDateFromString("2019-10-3"));

        c.printAllReminders();


    }
}
