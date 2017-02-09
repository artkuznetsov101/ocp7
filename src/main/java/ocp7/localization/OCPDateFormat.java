package ocp7.localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class OCPDateFormat {
    static int[] styles = new int[] { DateFormat.FULL, DateFormat.LONG, DateFormat.MEDIUM, DateFormat.SHORT };
    static String[] desc = new String[] { "FULL", "LONG", "MEDIUM", "SHORT" };

    public static void main(String[] args) {
        Date date = new Date();
        defaultLocale(date);
        specificLocale(Locale.GERMANY, date);
        specificLocale(Locale.FRANCE, date);
        specificLocale(Locale.CHINA, date);
    }

    static void defaultLocale(Date date) {
        msg("\nDefault Locale:");
        for (int style : styles) {
            DateFormat nfDefault = DateFormat.getDateInstance(style);
            msg(desc[style] + "\t:" + nfDefault.format(date));
        }
    }

    static void specificLocale(Locale locale, Date date) {
        msg("\n" + locale.getDisplayCountry());
        for (int style : styles) {
            DateFormat spec = DateFormat.getDateInstance(style, locale);
            msg(desc[style] + "\t:" + spec.format(date));
        }
    }

    static void msg(String str) {
        System.out.println(str);
    }
}
