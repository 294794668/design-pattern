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
    private static volatile AtomicInteger atomicInteger = new AtomicInteger();
    private ReentrantLock lock = new ReentrantLock();
    private Condition pc = lock.newCondition();
    private Condition cc = lock.newCondition();

    public class Producer implements Runnable {

        private int i;

        public Producer(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                if (atomicInteger.get() == 10) {
                    cc.signalAll();
                    pc.await();
                }
                System.out.println("put" + i);
                atomicInteger.incrementAndGet();
                queue.add(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public class Consumer implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                if (atomicInteger.get() == 0) {
                    pc.signalAll();
                    cc.await();
                }
                System.out.println("get" + queue.poll());
                atomicInteger.decrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
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
