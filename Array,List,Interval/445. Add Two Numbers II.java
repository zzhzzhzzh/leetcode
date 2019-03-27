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
        HashMap<ListNode, ListNode> map1 = new HashMap<>();
        HashMap<ListNode, ListNode> map2 = new HashMap<>();
        ListNode last = null;
        ListNode tail1 = l1;
        while (tail1 != null) {
            map1.put(tail1, last);
            last = tail1;
            tail1 = tail1.next;
        }
        tail1 = last;
        last = null;
        ListNode tail2 = l2;
        while (tail2 != null) {
            map2.put(tail2, last);
            last = tail2;
            tail2 = tail2.next;
        }
        tail2 = last;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = null;
        while (tail1 != null && tail2 != null) {
            int num = (tail1.val + tail2.val + carry) % 10;
            carry = (tail1.val + tail2.val + carry) / 10;
            //tail.next = new ListNode(num);
            ListNode node = new ListNode(num);
            node.next = tail;
            tail = node;
            tail1 = map1.get(tail1);
            tail2 = map2.get(tail2);
        }
        while (tail1 != null) {
            int num = (tail1.val + carry) % 10;
            carry = (tail1.val + carry) / 10;
            //tail.next = new ListNode(num);
            //tail = tail.next;
            ListNode node = new ListNode(num);
            node.next = tail;
            tail = node;
            tail1 = map1.get(tail1);
        }
        while (tail2 != null) {
            int num = (tail2.val + carry) % 10;
            carry = (tail2.val + carry) / 10;
            //tail.next = new ListNode(num);
            //tail = tail.next;
            ListNode node = new ListNode(num);
            node.next = tail;
            tail = node;
            tail2 = map2.get(tail2);
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = tail;
            tail = node;
        }
        return tail;
        
    }
}
