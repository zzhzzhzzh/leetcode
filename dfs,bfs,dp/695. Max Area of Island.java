//bfs
class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0 ,0};
    class Coordinate {
        int x, y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        max = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                bfs(grid, i, j);
            }
        return max;
    }
    public void bfs(int[][] grid, int i, int j) {
        int temp = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(i, j));
        grid[i][j] = 0;
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            temp++;
            // System.out.println(cur.x);
            // System.out.println(cur.y);
            // System.out.println();
            
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                Coordinate nCoor = new Coordinate(nx, ny);
                if (inBound(grid, nCoor) && grid[nx][ny] == 1) {
                    grid[nx][ny] = 0;
                    queue.offer(nCoor);
                }
            }
        }
        max = Math.max(max, temp);
    }
    public boolean inBound(int[][] grid, Coordinate pos) {
        return pos.x >= 0 && pos.x < grid.length && pos.y >= 0 && pos.y < grid[0].length;
    }
}


//dfs
public class Solution {
    /**
     * @param grid: a 2D array
     * @return: the maximum area of an island in the given 2D array
     * 通过dfs计算每个岛的大小
     */
    public int maxAreaOfIsland(int[][] grid) {
        // Write your code here
        int res = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j) {
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
        }
        return 0;
    }
}
