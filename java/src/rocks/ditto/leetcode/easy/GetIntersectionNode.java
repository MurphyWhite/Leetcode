package src.rocks.ditto.leetcode.easy;

import src.rocks.ditto.leetcode.common.ListNode;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果有相交的话，队尾的元素一定是一样的
        int aLength = 0, bLength = 0;
        ListNode aNode = headA, bNode = headB;
        while(aNode != null){
            aLength++;
            aNode = aNode.next;
        }
        while (bNode != null){
            bLength++;
            bNode = bNode.next;
        }
        // 先把相差的长度先过滤掉，再一起遍历
        int temp = Math.abs(aLength - bLength);
        while (temp > 0){
            temp--;
            if (aLength > bLength){
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        // 一起遍历
        while (headA != null && headB != null){
            if (headA.equals(headB)){
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
