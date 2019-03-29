/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!map.containsKey(cur))
                map.put(cur, new Node(cur.val, new ArrayList<Node>()));
            for (Node n: cur.neighbors) {
                if (!map.containsKey(n)) {
                    queue.offer(n);
                    map.put(n, new Node(n.val, new ArrayList<Node>()));
                }
                map.get(cur).neighbors.add(map.get(n));
                
            }
        }
        return map.get(node);
    }
}
