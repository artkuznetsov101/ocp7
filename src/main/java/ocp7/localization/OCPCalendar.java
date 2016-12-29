package ocp7.localization;

import java.util.Calendar;
import java.util.Date;

public class OCPCalendar {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(1973, Calendar.SEPTEMBER, 30, 14, 10, 40);
        Date date = cal.getTime();
        System.out.print(date);
    }
}
