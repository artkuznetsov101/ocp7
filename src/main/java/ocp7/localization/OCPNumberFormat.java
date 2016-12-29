package ocp7.localization;

import java.text.NumberFormat;
import java.util.Locale;

public class OCPNumberFormat {
    public static void main(String[] args) {
        double num = 12345.1111;
        defaultLocale(num);
        specificLocale(Locale.GERMANY, num);
        specificLocale(Locale.FRANCE, num);
        specificLocale(Locale.US, num);
    }

    static void defaultLocale(double num) {
        NumberFormat nfDefault = NumberFormat.getInstance();
        NumberFormat nfDefaultCurr = NumberFormat.getCurrencyInstance();
        msg("\nDefault Locale " + Locale.getDefault().getDisplayCountry());
        msg("\nDefault Locale Currency:" + nfDefaultCurr.getCurrency());
        msg("formatting: " + nfDefault.format(num));
        msg("formatting currency: " + nfDefaultCurr.format(num));
        try {
            msg("parsing : " + nfDefault.parse("12345.1111"));
        } catch (java.text.ParseException e) {
            msg(e.toString());
        }
    }

    static void specificLocale(Locale locale, double num) {
        NumberFormat nfSpecific = NumberFormat.getInstance(locale);
        NumberFormat nfDefaultCurr = NumberFormat.getCurrencyInstance(locale);
        msg("\n" + locale.getDisplayCountry());
        msg("Locale Currency:" + nfDefaultCurr.getCurrency());
        msg("formatting: " + nfSpecific.format(num));
        msg("formatting currency: " + nfDefaultCurr.format(num));
        try {
            msg("parsing : " + nfSpecific.parse("12345.1111"));
        } catch (java.text.ParseException e) {
            msg(e.toString());
        }
    }

    static void msg(String str) {
        System.out.println(str);
    }
}
