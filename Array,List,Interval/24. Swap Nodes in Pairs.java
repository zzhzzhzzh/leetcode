/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            last.next = temp;
            head.next = temp.next;
            temp.next = head;
            last = head;
            head = head.next;
        }
        return dummy.next;
    }
    
}
