package ocp7.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

class Reminder implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}

class OCPScheduledExecutorService {
    ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    Reminder reminder1 = new Reminder();
    Reminder reminder2 = new Reminder();
    Reminder reminder3 = new Reminder();
    List<Reminder> list = new ArrayList<Reminder>();

    public void sendReminders() throws InterruptedException, ExecutionException {
        list.add(reminder1);
        list.add(reminder2);
        list.add(reminder3);

        //		List<Future<String>> result = service.invokeAll(list);
        //		for (Future<String> item : result) {
        //			System.out.println(item.get());
        //		}
    }

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        OCPScheduledExecutorService mgr = new OCPScheduledExecutorService();
        mgr.sendReminders();
        mgr.service.shutdown();
    }
}
