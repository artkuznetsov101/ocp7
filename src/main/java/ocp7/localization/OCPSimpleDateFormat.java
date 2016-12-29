package ocp7.localization;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OCPSimpleDateFormat {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat defaultFormatter = new SimpleDateFormat("'Date is:' EE', 'dd MMMM YYYY G");
        System.out.println(defaultFormatter.format(date));
    }
}
