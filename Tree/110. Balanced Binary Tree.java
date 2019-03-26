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
    class ResultType {
        boolean isBalanced;
        int height;
        ResultType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (left.isBalanced == false || right.isBalanced == false) {
            return new ResultType(0, false);
        }
        if (Math.abs(left.height - right.height) > 1) {
            return new ResultType(0, false);
        }
        return new ResultType(Math.max(left.height, right.height) + 1, true);
        
    }
}
