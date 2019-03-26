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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curt = queue.poll();
                if (depth % 2 == 1) {
                    level.add(curt.val);
                } else {
                    level.add(0, curt.val);
                }
                if (curt.left != null) {
                    queue.offer(curt.left);
                }
                if (curt.right != null) {
                    queue.offer(curt.right);
                }
            }
            res.add(level);
            depth++;
        }
        return res;
    }
}
