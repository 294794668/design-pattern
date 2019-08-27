package algorithems;

public interface Stack<T> {

    /**
     * 往栈中添加一个新的元素
     *
     * @param s 元素
     */
    void push(T s);

    /**
     * 移除并返回最近添加的元素
     *
     * @return 最近添加的元素
     */
    T pop();

    /**
     * @return 栈是否为空
     */
    boolean isEmpty();

    /**
     * @return 栈中元素的个数
     */
    int size();
}