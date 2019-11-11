package base;

/**
 * @author pengfei.cheng
 * 单链表node
 * @since 2019/11/11 下午7:03
 */
public class LinkNode {
    public int val;
    public LinkNode next;

    public LinkNode(int x) {
        val = x;
    }

    public LinkNode add(int x) {
        next = new LinkNode(x);
        return next;
    }
}
