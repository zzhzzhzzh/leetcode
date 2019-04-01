//bfs
class Solution {
    class Coordinate {
        int x, y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[] dx = {0 ,0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                    bfs(grid, i, j);
                    res++;
                
            }
        return res;
    }
    public void bfs(char[][] grid, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        grid[x][y] = '0';
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(cur.x + dx[i], cur.y + dy[i]);
                if (!inBound(grid, adj.x, adj.y)) {
                    continue;
                }
                if (grid[adj.x][adj.y] == '1') {
                    queue.offer(adj);
                    grid[adj.x][adj.y] = '0';
                }
            }
            
        }
    }
    public boolean inBound(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
//DFS
class Solution {
    int m , n;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                ans++;
                dfs(grid, i, j);
            }
        }
        return ans;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
