/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * 返回链表入环开始的第一个结点 空间复杂度要求是O(1)
 * 
 * 画图后可以得倒下面的思路： 1 快慢指针同时出发，第一次相遇在一个点 2 此时额外指定一个指针从头和慢指针以相同的速度出发，相遇点就是入口
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            // 快慢指针第一次相遇
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next; // 此时已经确定不存在环了
                }
                return slow;
            }
        }
        // 一旦为空，证明没有环，返回null
        return null;
    }
}