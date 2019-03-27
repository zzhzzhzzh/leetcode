/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;
    }
}

//反转前k个节点
public ListNode reverFirstKNodes(ListNode head, int k) {
    if (head == null) return null;
    ListNode dummy = new ListNode(0);
    dummy.next =head;
    Stack<ListNode> stack = new Stack<>();
    ListNode pNode = dummy;
    for (int i = 1; i <= k + 1) {
        stack.push(pNode);
        pNode = pNode.next;
        if (i == k) dummy.next = pNode;
        if (pNode == null) break;
    }
    while (!stack.isEmpty()) {
        ListNode cur = stack.pop();
        if (!stack.isEmpty()) {
            cur.next = stack.peek();
        } else {
            cur.next = pNode;
        }
    }
    return dummy.next;
}
