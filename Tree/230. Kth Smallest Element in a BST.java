/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//traverse
class Solution {
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        traverse(root.right);
    }
}


//
public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> numOfChildren = new HashMap<>();
        countNodes(root, numOfChildren);
        return quickSelectOnTree(root, k, numOfChildren);
    }
    private int countNodes(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left, map);
        int right = countNodes(root.right, map);
        map.put(root, left + right + 1);
        return left + right + 1;
    }
    private int quickSelectOnTree(TreeNode root, int k, Map<TreeNode, Integer> map) {
        if (root == null) {
            return -1;
        }
        int left = root.left == null? 0: map.get(root.left);
        if (left >= k) {
            return quickSelectOnTree(root.left, k, map);
        }
        if (left + 1 == k) {
            return root.val;
        }
        return quickSelectOnTree(root.right, k - left - 1, map);
    }
}
