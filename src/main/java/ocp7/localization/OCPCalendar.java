package ocp7.localization;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class OCPCalendar {
    public static void main(String[] args) {

        //set
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1982, Calendar.SEPTEMBER, 20, 14, 10, 40);
        Date date = cal1.getTime();
        System.out.println(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(date));

        //add
        cal1.add(Calendar.DAY_OF_MONTH, -8);
        cal1.add(Calendar.YEAR, -22);
        date = cal1.getTime();
        System.out.println(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(date));

        //roll
        cal1.roll(Calendar.YEAR, true);
        cal1.roll(Calendar.MONTH, true);
        cal1.roll(Calendar.DAY_OF_MONTH, true);
        date = cal1.getTime();
        System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(date));

        //roll
        cal1.roll(Calendar.YEAR, -1);
        cal1.roll(Calendar.MONTH, -1);
        cal1.roll(Calendar.DAY_OF_MONTH, -1);
        date = cal1.getTime();
        System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(date));
    }
}
