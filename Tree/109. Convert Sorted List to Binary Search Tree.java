/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return  helper(head, null);
    }
    public TreeNode helper(ListNode head, ListNode end) {
        if (head == null) {
            return null;
        }
        if (head.next == end) {
            return new TreeNode(head.val);
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (slow != head)
            root.left = helper(head, slow);
        root.right = helper(slow.next, end);
        return root;
    }
}
