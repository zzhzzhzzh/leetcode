class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            //System.out.println(1);
            if (ch[i - 1] - '0' != 0) {
                dp[i] += dp[i-1];
            }
            if (i > 1 && (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0') >= 10 && (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0') <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[ch.length];
    }
}
