package algorithems.impl;

import algorithems.Queue;

/**
 * @author pengfei.cheng
 * @description 栈实现类
 * @date 2019-08-27 14:21
 */
public class LinkedQueue<T> implements Queue<T> {

    class Node<V> {

        private V t;

        Node(V t) {
            this.t = t;
        }

        private Node<V> next;
    }

    private Node<T> first;
    private Node<T> last;
    private int number = 0;


    /**
     * 往队列中添加一个新的元素
     *
     * @param e 新的元素
     */
    @Override
    public void enqueue(T e) {
        Node temp = new Node<>(e);
        if (first == null) {
            first = temp;
            last = temp;
        } else {
            last.next = temp;
            last = temp;
        }
        number++;
    }

    /**
     * 移除队列中最早添加的元素
     *
     * @return 最早添加的元素
     */
    @Override
    public T dequeeue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> popNode = first;
        first = first.next;
        number--;
        return popNode.t;
    }

    /**
     * @return 栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return number <= 0;
    }

    /**
     * @return 栈中元素的个数
     */
    @Override
    public int size() {
        return number;
    }


    public void print() {
        Node<T> temp = first;
        while (temp != null) {
            System.out.print(temp.t + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        for (int i = 0; i < 50; i++) {
            linkedQueue.enqueue(i);
            linkedQueue.print();
        }
        System.out.println("-----------------------------");
        for (int i = 0; i < 51; i++) {
            linkedQueue.dequeeue();
            linkedQueue.print();

        }
    }
}
