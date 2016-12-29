package ocp7.io.byte_rw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Car implements Serializable {
}

class OCPObjectStream {
    public static void main(String args[]) throws Exception {
        try (FileOutputStream out = new FileOutputStream("object.data");
                ObjectOutputStream oos = new ObjectOutputStream(out);
                FileInputStream in = new FileInputStream("object.data");
                ObjectInputStream ois = new ObjectInputStream(in);) {
            Car c = new Car();
            oos.writeObject(c);
            oos.flush();
            Car c2 = (Car) ois.readObject();
            System.out.println(c2);
        }
    }
}
