//邻接表中两个点之间所有的路径
public class Solution {
    /**
     * @param graph: a 2D array
     * @return: all possible paths from node 0 to node N-1
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        return res;
    }
    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int next: graph[node]) {
            path.add(next);
            dfs(graph, next, path, res);
            path.remove(path.size() - 1);
        }
    }
}
//矩阵从左上角到右下角
public List<String> printPath(int[][] m, int n)
    {         
         List<String> res = new ArrayList<>();
         if (n == 0 || m == null || m.length == 0) {
             return res;
         }
         String path = "";
         dfs(m, n, 0, 0, path, res);        
         return res;
    }
    private void dfs(int[][] m, int n, int x, int y, String path, List<String> res) {
        if(x == n - 1 && y == n - 1) {
            res.add(path);
            path = path.substring(0, path.length() - 1);
            return;
        }
        
        if (x + 1 >= 0 && x + 1 < n && y >= 0 && y < n && m[x + 1][y] == 1) {
            path = path + "D";
            dfs(m, n, x + 1, y, path, res);
            path = path.substring(0, path.length() - 1);
        }
        if (y + 1 >= 0 && y + 1 < n && x >= 0 && x < n && m[x][y + 1] == 1) {
            path = path + "R";
            dfs(m, n, x, y + 1, path, res);
            path = path.substring(0, path.length() - 1);
        }
    }
