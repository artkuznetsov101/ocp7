package ocp7.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

class BaseException extends IOException {
}

class DerivedException extends FileNotFoundException {
}

interface Base {
    void read() throws BaseException;
}

interface Derived extends Base {
    //error
    //void read() throws DerivedException;
    //void read() throws Exception;
    //ok
    void read();
    //void read() throws RuntimeException;
}

public class OCPDerivedException {

}
