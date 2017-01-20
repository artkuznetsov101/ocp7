package ocp7.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class OCPForkJoin extends RecursiveTask<Integer> {
    int[] ia;
    int from;
    int to;
    static final int THRESHOLD = 3;

    public OCPForkJoin(int[] ia, int from, int to) {
        this.ia = ia;
        this.from = from;
        this.to = to;
    }

    public int transform(int t) {
        //this can be a CPU intensive operation that transforms t and returns the value   
        //For now, just return t         
        return t;
    }

    protected Integer compute() {
        int sum = 0;
        if (from + THRESHOLD > to) {
            for (int i = from; i <= to; i++) {
                sum = sum + transform(ia[i]);
            }
        } else {
            int mid = (from + to) / 2;
            OCPForkJoin newtask1 = new OCPForkJoin(ia, from, mid);
            OCPForkJoin newtask2 = new OCPForkJoin(ia, mid + 1, to);
            newtask2.fork();
            sum = newtask1.compute() + newtask2.join();
        }
        return sum;
    }

    public static void main(String[] args) {

        int ia[] = new int[] { 10, 10, 10, 10, 10 };

        ForkJoinPool fjp = new ForkJoinPool();
        OCPForkJoin st = new OCPForkJoin(ia, 0, 4);

        int sum = fjp.invoke(st);

        System.out.println("sum = " + sum);
    }
}