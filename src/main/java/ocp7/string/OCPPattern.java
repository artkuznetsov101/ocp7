package ocp7.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OCPPattern {
    public static void main(String[] args) {
        String targetString = "I am fine to dine at nine";
        String regex = "[fdn]ine";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(targetString);
        while (matcher.find()) {
            System.out.println(matcher.group() + " starts at " + matcher.start() + ", ends at " + matcher.end());
        }
    }
}