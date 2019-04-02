public class Solution {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order successor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode succ = null;
        while (root != null) {
            if (p.val <= root.val) {
                root = root.left;
            } else {
                if(succ == null || root.val > succ.val){
                    succ = root;
                }
                root = root.right;
                
            }
        }
        return succ;        
    }
}

