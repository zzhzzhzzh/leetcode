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
    List<Integer> list;
    public int sumNumbers(TreeNode root) {
        list = new ArrayList<>();
        helper(root, 0);
        int sum = 0;
        for (int num: list) {
            sum += num;
        }
        return sum;
    }
    public void helper(TreeNode root, int prev) {
        if (root == null) {
            list.add(prev);
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(prev*10 + root.val);
            return;
        }
        if (root.left != null)
            helper(root.left, prev * 10 + root.val);
        if (root.right != null)
            helper(root.right, prev * 10 + root.val);
        
    }
}
