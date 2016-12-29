package ocp7.string;

public class OCPStringSplit {
    public static void main(String[] args) {
        String in = "1 a2 b 3 c4d 5e";
        String regex = "\\d";

        String[] chunks = in.split(regex);
        System.out.println("count: " + chunks.length);
        for (String s : chunks)
            System.out.println(">" + s + "<");
    }
}
