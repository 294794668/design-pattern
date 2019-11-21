package juc.question;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengfei.cheng
 * 生产者与消费者
 * @since 2019/11/11 下午7:07
 */
public class ProducerAndConsumer {

    private static volatile Queue<Integer> queue = new LinkedBlockingQueue<>(10);
    private static volatile AtomicInteger atomicInteger = new AtomicInteger(0);
    private ReentrantLock pl = new ReentrantLock();
    private ReentrantLock cl = new ReentrantLock();
    private Condition pc = pl.newCondition();
    private Condition cc = cl.newCondition();

    public class Producer implements Runnable {

        private int i;

        public Producer(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            pl.lock();
            int c = -1;
            try {
                while (atomicInteger.get() == 10) {
                    pc.await();
                }
                System.out.println("+++" + i);
                queue.add(i);
                c = atomicInteger.incrementAndGet();
                if (c < 10) {
                    pc.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pl.unlock();
            }
            if (c == 10) {
                try {
                    cl.lock();
                    cc.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    cl.unlock();
                }
            }

        }
    }

    public class Consumer implements Runnable {
        @Override
        public void run() {
            cl.lock();
            int c = -1;
            try {
                while (atomicInteger.get() == 0) {
                    cc.await();
                }
                System.out.println("---" + queue.poll());
                c = atomicInteger.decrementAndGet();
                if (c > 0) {
                    cc.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cl.unlock();
            }
            if (c == 0) {
                try {
                    pl.lock();
                    pc.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    pl.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer demo = new ProducerAndConsumer();
        for (int i = 0; i < 100; i++) {
            new Thread(demo.new Producer(i)).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(demo.new Consumer()).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
