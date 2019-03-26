/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//amazon 面试版，求vertical sum
// class Solution {
    
//     public List<Integer> verticalOrder(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         if (root == null) return res;
        
//         Map<Integer, List<TreeNode>> map = new HashMap<>();
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         Queue<TreeNode> queue1 = new LinkedList<>();
//         Queue<Integer> queue2 = new LinkedList<>();
//         queue2.offer(0);
//         queue1.offer(root);
        
//         while (!queue1.isEmpty()) {
//             TreeNode cur = queue1.poll();
//             int column = queue2.poll();
//             min = Math.min(min, column);
//             max = Math.max(max, column);
//             if (!map.containsKey(column)) {
//                 map.put(column, new ArrayList<>());
//             }
//             map.get(column).add(cur);
//             if (cur.left != null) {
//                 queue1.offer(cur.left);
//                 queue2.offer(column - 1);
//             }
//             if (cur.right != null) {
//                 queue1.offer(cur.right);
//                 queue2.offer(column + 1);
//             }
//         }
        
//         for (int i = min; i <= max; i++) {
//             int sum = 0;
//             for (TreeNode node: map.get(i)) {
//                 sum += node.val;
//             }
//             res.add(sum);
//         }
//         return res;
//     }
   
// }
class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.offer(0);
        queue1.offer(root);
        
        while (!queue1.isEmpty()) {
            TreeNode cur = queue1.poll();
            int column = queue2.poll();
            min = Math.min(min, column);
            max = Math.max(max, column);
            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<>());
            }
            map.get(column).add(cur);
            if (cur.left != null) {
                queue1.offer(cur.left);
                queue2.offer(column - 1);
            }
            if (cur.right != null) {
                queue1.offer(cur.right);
                queue2.offer(column + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            List<Integer> list = new ArrayList<>();
            for (TreeNode node: map.get(i)) {
                list.add(node.val);
            }
            lists.add(list);
        }
        return lists;
    }
   
}

//bottom view of a binary tree



