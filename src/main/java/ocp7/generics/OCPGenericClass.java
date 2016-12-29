package ocp7.generics;

class Book {
}

class Parcel<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

class OCPGenericClass {
    public static void main(String args[]) {
        Parcel<Book> parcel = new Parcel<Book>();
        parcel.set(new Book());
        Book myBook = parcel.get();
    }
}
