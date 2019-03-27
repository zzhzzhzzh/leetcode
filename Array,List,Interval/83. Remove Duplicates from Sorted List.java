/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        while (tail!= null && tail.next != null) {
            if (tail.val == tail.next.val) {
                tail.next = tail.next.next;
            } else {
                tail = tail.next;
            }
            
        }
        return dummy.next;
        
    }
 }

//remove duplicates from lists
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        Set<Integer> set = new HashSet<>();
        while (head != null && head.next != null) {
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                set.add(head.next.val);
                head = head.next;
            }
        }
        return dummy.next;
    }
