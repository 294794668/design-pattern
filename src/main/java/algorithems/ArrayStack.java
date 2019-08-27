package algorithems;

/**
 * @author pengfei.cheng
 * @description 数组实现的栈
 * @date 2019-08-27 14:24
 */
public class ArrayStack<T> implements Stack<T> {

    private Object[] array;
    private int number = 0;

    public ArrayStack(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public void push(T s) {
        if (number >= array.length) {
            Object[] objects = new Object[array.length * 2];
            System.arraycopy(array, 0, objects, 0, array.length);
            array = objects;
        }
        array[number] = s;
        number++;
    }

    @Override
    public T pop() {
        number--;
        T t = (T) array[number];
        array[number] = null;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return number == 0;
    }

    @Override
    public int size() {
        return number;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        for (int i = 0; i < 50; i++) {
            arrayStack.push(i);
            arrayStack.print();
        }
        System.out.println("-----------------------------");
        for (int i = 0; i < 30; i++) {
            System.out.println(arrayStack.pop());
            arrayStack.print();

        }
    }
}
