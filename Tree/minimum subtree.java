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
        int sum;
        int minSum;
        TreeNode minNode;
        ResultType(int sum,int minSum) {
            this.sum = sum;
            this.minSum = minSum;
            minNode = null;
        }
    }
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        return minSubtree(root).minNode;
    }
    
    private ResultType minSubtree(TreeNode node) {
        if (node == null) {
            return new ResultType(0, Integer.MAX_VALUE);
        }
        ResultType left = minSubtree(node.left);
        ResultType right = minSubtree(node.right);
        
        int sum = left.sum + right.sum + node.val;
        int minSum = sum;
        ResultType res = new ResultType(sum, minSum);
        res.minNode = node;
        if ( res.minSum > left.minSum) {
            res.minSum = left.minSum;
            res.minNode = left.minNode;
        } 
        if ( res.minSum > right.minSum) {
            res.minSum = right.minSum;
            res.minNode = right.minNode;
        }
        return res;
    }
}
