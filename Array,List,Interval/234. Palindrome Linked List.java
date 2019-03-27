/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = reverse(slow);
        while (p != null && head != null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode last = null;
        ListNode nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = last;
            last = head;
            head = nextNode;
        }
        if (last != null) {
            return last;
        } else {
            return head;
        }
    }
}
