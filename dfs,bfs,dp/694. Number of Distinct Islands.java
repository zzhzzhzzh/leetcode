class Solution {
    int m = 0, n = 0;
    Set<String> set = new HashSet<>();
    boolean[][] visited = null;
    String temp = "";
    int ix = 0, iy = 0;
    int[] dx = {0, 0, -1 ,1};
    int[] dy = {1, -1, 0, 0};
    
    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    temp = "";
                    ix = i;
                    iy = j;
                    dfs(grid, i, j);
                    set.add(temp);
                }
                
            }
        return set.size();
    }
    public void dfs(int[][] grid, int x, int y) {
        visited[x][y] = true;
        temp += (x - ix) + "" + (y - iy);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!inBound(grid, nx, ny) || visited[nx][ny] || grid[nx][ny] == 0) continue;
            dfs(grid, nx, ny);
        }
    }
    public boolean inBound(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
