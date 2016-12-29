package ocp7.advanced;

class OCPAnonymous {
    public static void main(String args[]) {
        Lecture lecture = new Lecture();
        lecture.notes(new Pen() {
            public void write() {
                System.out.println("Okay! I am writing");
            }
        });
    }
}

class Pen {
    public void write() {
        System.out.println("Pen-write");
    }
}

class Lecture {
    public void notes(Pen pen) {
        pen.write();
    }
}
