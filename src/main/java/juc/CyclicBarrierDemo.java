package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private final int N;
    private final float[][] data;
    private final CyclicBarrier barrier;

    class Worker implements Runnable {
        int myRow;

        Worker(int row) {
            myRow = row;
        }

        public void run() {
//            while (!done()) {
                System.out.println(myRow+ "-start");
                try {
                    barrier.await();
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
            System.out.println(myRow+ "-end");
//            }
        }

        private boolean done() {
            float[] datum = data[myRow];
            return true;
        }
    }

    public CyclicBarrierDemo(float[][] matrix) throws InterruptedException {
        data = matrix;
        N = matrix.length;
        Runnable barrierAction = () -> System.out.println("barrier");
        barrier = new CyclicBarrier(6, barrierAction);

        List<Thread> threads = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }

        // wait until done
        for (Thread thread : threads)
            thread.join();
    }

    public static void main(String[] args) {
        try {
            new CyclicBarrierDemo(new float[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
