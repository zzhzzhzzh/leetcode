class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dpUp = new int[m][n];
        int[][] dpLeft = new int[m][n];
        int[][] dpDown = new int[m][n];
        int[][] dpRight = new int[m][n];
        // char c = 'E';
        // System.out.println(c == 'E'? 1: 0);
        // System.out.println();
        //up
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dpUp[i][j] = grid[i][j] == 'E'? 1: 0;
                    //System.out.println(dpUp[i][j]);
                    continue;
                }
                if (grid[i][j] == 'W') {
                    //System.out.println(dpUp[i][j]);
                    continue;
                }
                // if (grid[i][j] == 'E') {
                //     dpUp[i][j] = 1 + dpUp[i - 1][j];
                // } else {
                //     dpUp[i][j] += dpUp[i - 1][j];
                // }
                int val;
                val = grid[i][j] == 'E'? 1: 0;
                dpUp[i][j] = dpUp[i - 1][j] + val; 
                
                //System.out.println(dpUp[i][j]);
            }
        //left
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dpLeft[i][j] = grid[i][j] == 'E'?1: 0;
                    //System.out.println(dpUp[i][j]);
                    continue;
                }
                if (grid[i][j] == 'W') {
                    //System.out.println(dpUp[i][j]);
                    continue;
                }
                int val;
                val = grid[i][j] == 'E'? 1: 0;
                dpLeft[i][j] = dpLeft[i][j - 1] + val;
                //System.out.println(dpUp[i][j]);
            }
        //down
        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < n; j++) {
                if (i == m - 1) {
                    dpDown[i][j] = grid[i][j] == 'E'?1: 0;
                    //System.out.println(dpUp[i][j]);
                    continue;
                }
                if (grid[i][j] == 'W') {
                    //System.out.println(dpUp[i][j]);
                    continue;
                }
                int val;
                val = grid[i][j] == 'E'? 1: 0;
                dpDown[i][j] = dpDown[i + 1][j] + val;
                //System.out.println(dpUp[i][j]);
            }
        //right
        for (int i = 0; i < m; i++)
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    dpRight[i][j] = grid[i][j] == 'E'? 1: 0;
                    //System.out.println(dpUp[i][j]);
                    continue;
                }
                if (grid[i][j] == 'W') {
                    //System.out.println(dpUp[i][j]);
                    continue;
                }
                int val;
                val = grid[i][j] == 'E'? 1: 0;
                dpRight[i][j] = dpRight[i][j + 1] + val;
                //System.out.println(dpUp[i][j]);
            }
        
        int max = 0;
        int sum = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    sum = dpUp[i][j] + dpLeft[i][j] + dpDown[i][j] + dpRight[i][j];
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        return max;
        
    }
}
