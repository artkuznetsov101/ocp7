package ocp7.localization;

import java.util.Locale;

public class OCPLocalization {
    public static void main(String args[]) {

        Locale[] all = Locale.getAvailableLocales();
        for (Locale curr : all)
            System.out.println("all: " + curr + " country: " + curr.getDisplayCountry() + " lang: " + curr.getDisplayLanguage());

        Locale curr = Locale.getDefault();
        System.out.println(curr + " country: " + curr.getDisplayCountry() + " lang: " + curr.getDisplayLanguage());

        Locale eng = new Locale("en", "GB");
        System.out.println(eng);

        Locale.Builder builder = new Locale.Builder();
        builder.setLanguage("fr");
        builder.setRegion("CA");
        Locale fr = builder.build();
        System.out.println(fr);

        Locale locale1 = Locale.FRENCH;
        Locale locale3 = new Locale.Builder().setLanguage("fr").build();
        System.out.println(locale1.equals(locale3));
        System.out.println(locale1);
        System.out.println(locale3);

        Locale locale2 = Locale.FRANCE;
        Locale locale6 = new Locale("fr", "FR");
        System.out.println(locale2.equals(locale6));
        System.out.println(locale2);
        System.out.println(locale6);

        Locale locale4 = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        Locale locale5 = new Locale("fr");
        System.out.println(locale4.equals(locale5));
        System.out.println(locale4);
        System.out.println(locale5);
    }
}
