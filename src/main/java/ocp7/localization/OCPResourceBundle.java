package ocp7.localization;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OCPResourceBundle {
    JFrame f = new JFrame("name");
    JLabel lname = new JLabel();
    JButton button = new JButton();

    private void buildShowUI() {
        f.getContentPane().setLayout(new FlowLayout());
        f.setSize(300, 400);
        f.getContentPane().add(lname);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1));
        panel1.add(new JLabel(""));
        panel1.add(button);
        f.getContentPane().add(panel1);
        f.setVisible(true);
    }

    private void setLocaleSpecificData(Locale locale) {

        ResourceBundle labels = ResourceBundle.getBundle("res", locale);
        String text = null;
        text = labels.getString("name");
        lname.setText(text);
        text = labels.getString("name");
        button.setText(text);
    }

    public static void main(String[] args) {

        System.out.println(Paths.get("").toAbsolutePath());
        System.out.println(Locale.getDefault());

        OCPResourceBundle ia = new OCPResourceBundle();
        ia.setLocaleSpecificData(new Locale("en", "GB"));
        ia.buildShowUI();
    }
}