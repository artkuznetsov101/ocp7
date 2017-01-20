package ocp7.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OCPPattern2 {
    public static void main(String[] args) {
        String targetString = "A b$9;";
        String regex = "\\W";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(targetString);
        String replacedStr = matcher.replaceAll("[]");
        System.out.println(replacedStr);

        String str = "o brother, where art thou! boo man!";
        String rex = "\\b";
        String replace = "X";
        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher(str);
        String val = m.replaceAll(replace);
        System.out.println(val);

    }
}
