/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//recursion
class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(null, head);
    }
    public ListNode helper(ListNode lastNode, ListNode head) {
        if (head == null) return lastNode;
        ListNode nextNode = head.next;
        head.next = lastNode;
        return helper(head, nextNode);
    }
}

//iteration
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null) return null;
//         ListNode lastNode = null, nextNode = null;
//         while (head.next != null) {
//             nextNode = head.next;
//             head.next = lastNode;
//             lastNode = head;
//             head = nextNode;
//         }
//         head.next = lastNode;
//         return head;
//     }
// }
