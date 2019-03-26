```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//非递归版本，用栈
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return res;
    }
    
}

//递归版本
class Solution {
     public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         helper(root, res);
         return res;
     }
     public void helper(TreeNode root, List<Integer> res) {
         if (root == null) return;
         res.add(root.val);
         helper(root.left, res);
         helper(root.right, res);
     }
 }
```
