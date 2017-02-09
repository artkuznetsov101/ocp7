package ocp7.localization;

import java.text.DecimalFormat;

public class OCPDecimalFormat {
    public static void main(String[] args) {
        double num = 12345.1111;
        defaultLocale(num);
    }

    static void defaultLocale(double num) {
        DecimalFormat nfDefault = new DecimalFormat("###.#");
        msg("no formatting: " + num);
        msg("formatting: " + nfDefault.format(num));
    }

    static void msg(String str) {
        System.out.println(str);
    }
}
