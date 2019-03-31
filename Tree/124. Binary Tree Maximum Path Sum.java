/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    int maxPath, singlePath;
    ResultType(int maxPath, int singlePath) {
        this.maxPath = maxPath;
        this. singlePath = singlePath;
    }
}
class Solution {
    
    public int maxPathSum(TreeNode root) {
        return helper(root).maxPath;
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int singlePath = root.val + Math.max(left.singlePath, right.singlePath);
        singlePath = Math.max(0, singlePath);
        int maxPath = root.val + left.singlePath + right.singlePath;
        maxPath = Math.max(maxPath, left.maxPath);
        maxPath = Math.max(maxPath, right.maxPath);
        return new ResultType(maxPath, singlePath);
    }
}
