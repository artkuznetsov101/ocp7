package ocp7.advanced;

abstract class OCPAbstract {
    abstract void run();
}

class Me extends OCPAbstract {
    void run() {
    }
}

abstract class You extends OCPAbstract {
    void run() {
    }
}

interface Run {
    void run();
}

//class Her extends OCPAbstract implements Run {
//    void run() {
//    }
//}

//abstract class His extends OCPAbstract {
//    String run() {
//    }
//}