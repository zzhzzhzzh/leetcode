/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            tail.next = p1;
        }
        if (p2 != null) {
            tail.next = p2;
        }
        return dummy.next;
    }
}
