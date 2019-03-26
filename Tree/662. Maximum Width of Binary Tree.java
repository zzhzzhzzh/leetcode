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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        queue.offer(root);
        column.offer(0);
        int res = Integer.MIN_VALUE;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftMost = Integer.MAX_VALUE;
            int rightMost = Integer.MIN_VALUE;
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int col = column.poll();
                leftMost = Math.min(leftMost, col);
                rightMost = Math.max(rightMost, col);
                if (cur.left != null) {
                    queue.offer(cur.left);
                    column.offer(col * 2 - 1);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    column.offer(col * 2);
                }
            }
            res = Math.max(res, rightMost - leftMost + 1);
        }
        return res;
    }
}
