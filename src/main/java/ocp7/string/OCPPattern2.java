package ocp7.string;

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
    }
}
