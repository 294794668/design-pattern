package algorithems;

/**
 * @author pengfei.cheng
 * @description 栈实现类
 * @date 2019-08-27 14:21
 */
public class LinkedStack<T> implements Stack<T> {

    class Node<V> {

        private V t;

        Node(V t) {
            this.t = t;
        }

        private Node<V> next;
    }

    private Node<T> first;
    private int number;

    /**
     * 往栈中添加一个新的元素
     *
     * @param s 元素
     */
    @Override
    public void push(T s) {
        Node<T> tNode = new Node<>(s);
        tNode.next = first;
        first = tNode;
        number++;
    }

    /**
     * 移除并返回最近添加的元素
     *
     * @return 最近添加的元素
     */
    @Override
    public T pop() {
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
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        for (int i = 0; i < 50; i++) {
            linkedStack.push(i);
            linkedStack.print();
        }
        System.out.println("-----------------------------");
        for (int i = 0; i < 51; i++) {
            System.out.println(linkedStack.pop());
            linkedStack.print();

        }
    }
}
