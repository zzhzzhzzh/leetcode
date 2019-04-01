class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j <dp[0].length; j++) {
                if(obstacleGrid[i][j] != 1) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = 0;
                }
                
            }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        
    }
}
