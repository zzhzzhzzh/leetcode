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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }
    public TreeNode helper(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postEnd]) {
                index = i;
                break;
            }
        }
        root.left = helper(postEnd - (inEnd - index) - 1, inStart, index - 1, postorder, inorder);
        root.right = helper(postEnd - 1, index  + 1, inEnd, postorder, inorder);
        return root;
    }
    
}
