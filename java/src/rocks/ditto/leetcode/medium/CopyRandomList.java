package src.rocks.ditto.leetcode.medium;


import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class CopyRandomList {

    static class Node {

        public int val;

        public Node next;

        public Node random;

        public Node(int val) {
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 空链表
        if (head == null) {
            return null;
        }
        // 哈希表 oldNode -> newNode
        Map<Node, Node> cacheMap = new HashMap<>();
        Node newHead = new Node(head.val);
        Node temp = newHead;
        cacheMap.put(head, newHead);
        // 构造头部节点
        if (head.random != null) {
            Node random = cacheMap.getOrDefault(head.random, new Node(head.random.val));
            newHead.random = random;
            cacheMap.put(head.random, random);
        }

        // 遍历参数
        while (head.next != null) {
            Node next = cacheMap.getOrDefault(head.next, new Node(head.next.val));
            // 要马上放入哈希表，random指针可以指向自己
            cacheMap.put(head.next, next);
            if (head.next.random != null) {
                next.random = cacheMap.getOrDefault(head.next.random, new Node(head.next.random.val));
            }
            cacheMap.put(head.next.random, next.random);
            temp.next = next;
            temp = temp.next;
            head = head.next;
        }
        return newHead;
    }
}
