package src.rocks.ditto.leetcode.easy;

import src.rocks.ditto.leetcode.common.ListNode;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 先判断特殊情况
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast){
            // 如果已经到尾部了，那么就结束
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
