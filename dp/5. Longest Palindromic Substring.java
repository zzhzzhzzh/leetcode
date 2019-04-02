class Solution {
    private int lo, maxlen;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2)
            return s;
        for(int i=0; i< len-1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo + maxlen);
    }
    
    private void extendPalindrome(String s, int j, int k) {
        while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if(maxlen < k-j-1) {
            lo = j+1;
            maxlen = k - j - 1;
        }
    }
    
}

//用动态规划做
public String longestPalindrome(String s) {
  int n = s.length();
  String res = null;
    
  boolean[][] dp = new boolean[n][n];
    
  for (int i = n - 1; i >= 0; i--) {
    for (int j = i; j < n; j++) {
      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            
      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
        res = s.substring(i, j + 1);
      }
    }
  }
    
  return res;
}
