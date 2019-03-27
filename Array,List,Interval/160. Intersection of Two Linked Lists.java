/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 空间o(1)做法
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = 0, lengthB = 0;
        ListNode indexA = headA, indexB = headB;
        while (indexA != null) {
            lengthA++;
            indexA = indexA.next;
        }
        while (indexB != null) {
            lengthB++;
            indexB = indexB.next;
        }
        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            while(diff-- != 0) {
                headA = headA.next;
            }
        } else if (lengthA < lengthB) {
            int diff = lengthB - lengthA;
            while (diff-- != 0) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

//set
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if (headA == null || headB == null) return null;
//         Set<ListNode> set = new HashSet<>();
//         ListNode indexA = headA;
//         while (indexA != null) {
//             set.add(indexA);
//             indexA = indexA.next;
//         }
//         while (headB != null) {
//             if (set.contains(headB)) {
//                 return headB;
//             }
//             headB = headB.next;
//         }
//         return null;
//     }
// }


