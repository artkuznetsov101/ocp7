package ocp7.concurrency;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class OCPReadWriteLock {

	private final ArrayList<String> theList = new ArrayList<String>();
	// Note that ReadWriteLock is an interface.
	private final ReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	public String read() {
		r.lock();
		try {
			System.out.println("reading");
			if (theList.isEmpty())
				return null;
			else
				return theList.get(0);
		} finally {
			r.unlock();
		}
	}

	public void write(String data) {
		w.lock();
		try {
			System.out.println("Written " + data);
			theList.add(data);
		} finally {
			w.unlock();
		}
	}
}