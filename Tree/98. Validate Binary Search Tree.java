/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    
    class ResultType {
        int minValue, maxValue;
        boolean isBST;
        ResultType(int minValue, int maxValue, boolean isBST) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.isBST = isBST;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (left.isBST == false || right.isBST == false) {
            return new ResultType(0, 0, false);
        }
        if (root.left != null && root.val <= left.maxValue) {
            return new ResultType(0, 0, false);
        }
        if (root.right != null && root.val >= right.minValue) {
            return new ResultType(0, 0, false);
        }
        return new ResultType(Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue) , true);
    }
}
