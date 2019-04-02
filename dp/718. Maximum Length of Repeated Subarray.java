class Solution {
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;
        int m = A.length + 1;
        int n = B.length + 1;
        int[][] dp = new int[m][n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (A[i - 1] == B[j - 1]) ? dp[i - 1][j - 1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        return res;
    }
}
