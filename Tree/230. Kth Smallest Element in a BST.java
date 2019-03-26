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
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        traverse(root.right);
    }
}
