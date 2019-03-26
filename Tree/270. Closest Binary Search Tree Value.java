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
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);
        if (lowerNode == null) return upperNode.val;
        if (upperNode == null) return lowerNode.val;
        
        if (upperNode.val - target > target - lowerNode.val) {
            return lowerNode.val;
        } else {
            return upperNode.val;
        }
    }
    public TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) return null;
        if (root.val == target) return root;
        
        if (root.val < target) {
            TreeNode cand = lowerBound(root.right, target);
            if (cand != null) {
                return cand;
            }
            return root;
        } else {
            return lowerBound(root.left, target);
        }
    }
    public TreeNode upperBound(TreeNode root, double target) {
        if (root == null) return null;
        if (root.val == target) return root;
        
        if (root.val > target) {
            TreeNode cand = upperBound(root.left, target);
            if (cand != null) {
                return cand;
            }
            return root;
        } else {
            return upperBound(root.right, target);
        }
    }
}
