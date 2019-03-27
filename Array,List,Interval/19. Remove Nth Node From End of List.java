/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        //System.out.println(right.val);
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        //System.out.println(left.val);
        left.next = left.next.next;
        return dummy.next;
        
    }
}
