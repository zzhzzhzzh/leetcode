/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        int carrier = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + carrier;
            carrier = num / 10;
            num %= 10;
            index.next = new ListNode(num);
            index = index.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int num = l1.val + carrier;
            carrier = num / 10;
            num = num % 10;
            index.next = new ListNode(num);
            l1 = l1.next;
            index = index.next;
        }
        while (l2 != null) {
            int num = l2.val + carrier;
            carrier = num / 10;
            num = num % 10;
            index.next = new ListNode(num);
            l2 = l2.next;
            index = index.next;
        }
        if (carrier != 0 && l1 == null && l2 == null) {
            index.next = new ListNode(carrier);
        }
        return dummy.next;
    }
}
