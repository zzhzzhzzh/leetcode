class Solution {
    /*
    这个题的思路是通过给节点进行染色，如果当前给这个节点染的色和他现有的颜色不一样，则说明有冲突发生
    
    */
    public boolean isBipartite(int[][] graph) {
        if (graph == null) {
            return false;
        }
        int color[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0 && dfs(graph, i, color, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int curNode, int[] color, int paintColor) {
        if (color[curNode] == paintColor) {
            return false;
        }       
        if (color[curNode] * -1 == paintColor) {
            return true;
        }
        color[curNode] = paintColor;
        for (int node: graph[curNode]) {
            if (dfs(graph, node, color, -1 * paintColor)) {
                return true;
            }
        }
        return false;
    } 
}
