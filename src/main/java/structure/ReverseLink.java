package structure;

import base.LinkNode;

/**
 * @author pengfei.cheng
 * 反转单链表
 * @since 2019/11/11 下午6:34
 */
public class ReverseLink {

    public static LinkNode reverse(LinkNode node) {
        LinkNode reverse = null;
        while (node != null) {
            LinkNode nextNode = node.next;
            node.next = reverse;
            reverse = node;
            node = nextNode;
        }
        return reverse;
    }

    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode(1);
        linkNode.add(2).add(3).add(4).add(5).add(6);
        LinkNode reverse = ReverseLink.reverse(linkNode);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
