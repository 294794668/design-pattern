package algorithems;

/**
 * @author pengfei.cheng
 * @description 队列
 * @date 2019-08-27 17:08
 */
public interface Queue<T> {
    /**
     * 往队列中添加一个新的元素
     *
     * @param e 新的元素
     */
    void enqueue(T e);

    /**
     * 移除队列中最早添加的元素
     *
     * @return 最早添加的元素
     */
    T dequeeue();

    /**
     * @return 队列是否为空
     */
    boolean isEmpty();

    /**
     * @return 队列中元素的个数
     */
    int size();
}
