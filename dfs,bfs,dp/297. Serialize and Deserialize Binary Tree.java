/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                sb.append(cur.val);
                sb.append(",");
                
            } else {
                sb.append("n,");
                continue;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] ch = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ch[0]));
        queue.offer(root);
        for (int i = 1; i < ch.length; i++) {
            TreeNode parent = queue.poll();
            if (!ch[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(ch[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (!ch[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(ch[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
