package algorithems;

/**
 * @author pengfei.cheng
 * @description 队列
 * @date 2019-08-27 17:08
 */
public interface Queue<T> {

    void enqueue(T e);

    T dequeeue();

    boolean isEmpty();

    int size();
}
