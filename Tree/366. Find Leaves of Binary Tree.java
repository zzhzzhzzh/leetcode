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
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int height = Math.max(left, right) + 1;
        if (height > res.size()) {
            ArrayList<Integer> level = new ArrayList<>();
            level.add(root.val);
            res.add(level);
        } else {
            res.get(height - 1).add(root.val);
        }
        return height;
    }
}
