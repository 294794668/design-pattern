package juc;

import java.awt.image.DataBuffer;
import java.util.concurrent.Exchanger;

/**
 * @author pengfei.cheng
 * @description 现场交换元素对象 FillAndEmpty
 * @date 2019-09-16 15:00
 */
public class ExchangerDemo {

    Exchanger<DataBuffer> exchanger = new Exchanger<>();
    DataBuffer initialEmptyBuffer = null;//...a made-up type
    DataBuffer initialFullBuffer = null;//...

//    class FillingLoop implements Runnable {
//        public void run() {
//            DataBuffer currentBuffer = initialEmptyBuffer;
//            try {
//                while (currentBuffer != null) {
//                    addToBuffer(currentBuffer);
//                    if (currentBuffer.isFull())
//                        currentBuffer = exchanger.exchange(currentBuffer);
//                }
//            } catch (InterruptedException ex) { ...handle ...}
//        }
//
//        private void addToBuffer(DataBuffer currentBuffer) {
//
//        }
//    }
//
//    class EmptyingLoop implements Runnable {
//        public void run() {
//            DataBuffer currentBuffer = initialFullBuffer;
//            try {
//                while (currentBuffer != null) {
//                    takeFromBuffer(currentBuffer);
//                    if (currentBuffer.isEmpty())
//                        currentBuffer = exchanger.exchange(currentBuffer);
//                }
//            } catch (InterruptedException ex) { ...handle ...}
//        }
//
//        private void takeFromBuffer(DataBuffer currentBuffer) {
//
//        }
//    }
//
//    void start() {
//        new Thread(new FillingLoop()).start();
//        new Thread(new EmptyingLoop()).start();
//    }
}
