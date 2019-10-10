package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author pengfei.cheng
 * @description test
 * @date 2019-09-12 14:17
 */
public class CountDownLatchDemo {

    class Driver { // ...
        void main() throws InterruptedException {
            int n = 10;
            CountDownLatch startSignal = new CountDownLatch(1);
            CountDownLatch doneSignal = new CountDownLatch(10);

            for (int i = 0; i < n; ++i) {// create and start threads
                new Thread(new Worker(startSignal, doneSignal, i)).start();
            }
            System.out.println(startSignal.getCount());
            System.out.println(doneSignal.getCount());
//            doSomethingElse();            // don't let run yet
            System.out.println("main before all threads proceed");
            startSignal.countDown();      // let all threads proceed
            System.out.println(startSignal.getCount());
            System.out.println("main after all threads proceed");
//            doSomethingElse();
            System.out.println(doneSignal.getCount() + "-for wait");
            doneSignal.await();           // wait for all to finish
            System.out.println(doneSignal.getCount() + "_after all");
            System.out.println("I'm the end");
        }
    }

    class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;
        private int anInt;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal, int i) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
            this.anInt = i;
        }

        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
                System.out.println(doneSignal.getCount() + "_signal");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } // return;
        }

        void doWork() {
            System.out.println(anInt + "-do work");
        }
    }

    public static void main(String[] args) {
        Driver driver = new CountDownLatchDemo().new Driver();
        try {
            driver.main();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
