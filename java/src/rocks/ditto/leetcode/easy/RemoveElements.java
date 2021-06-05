package src.rocks.ditto.leetcode.easy;

import src.rocks.ditto.leetcode.common.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        // 创建一个头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
                // 删除节点
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
