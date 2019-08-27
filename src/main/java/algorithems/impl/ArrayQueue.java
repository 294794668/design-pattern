package algorithems.impl;

import algorithems.Queue;

/**
 * @author pengfei.cheng
 * @description 队列
 * @date 2019-08-27 17:10
 */
public class ArrayQueue<T> implements Queue<T> {

    private Object[] array;
    private int number = 0;
    private int startIndex = 0;
    private int endIndex = 0;

    public ArrayQueue(int capacity) {
        array = new Object[capacity];
    }

    /**
     * 往队列中添加一个新的元素
     *
     * @param e 新的元素
     */
    @Override
    public void enqueue(T e) {
        array[number] = e;
        number++;
        endIndex++;
    }

    /**
     * 移除队列中最早添加的元素
     *
     * @return 最早添加的元素
     */
    @Override
    public T dequeeue() {
        T t = (T) array[startIndex];
        array[startIndex] = null;
        startIndex++;
        return t;
    }

    /**
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return number == 0;
    }

    /**
     * @return 队列中元素的个数
     */
    @Override
    public int size() {
        return number;
    }
}
