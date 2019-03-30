class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return dfs(s, 0, p, 0, visited, memo);
    }
    
    private boolean dfs(String s, int indexS, String p, int indexP, boolean[][] visited, boolean[][] memo) {
        if (indexS == s.length()) {
            return helper(p, indexP);
        }
        if (indexP == p.length()) {
            return indexS == s.length();
        }
        if (visited[indexS][indexP]) {
            return memo[indexS][indexP];
        }
        char sChar = s.charAt(indexS);
        char pChar = p.charAt(indexP);
        boolean match;
        
        if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') { // 
            match = dfs(s, indexS, p, indexP + 2, visited, memo) || isCharMatch(sChar, pChar) && dfs(s,indexS + 1, p, indexP, visited, memo);
        } else {
            match = isCharMatch(sChar, pChar) && dfs(s, indexS + 1, p, indexP + 1, visited, memo);
        }
        visited[indexS][indexP] = true;
        memo[indexS][indexP] = match;
        return match;
    }
    
    private boolean isCharMatch(char a, char b) {
        return a == b || b == '.';
    }
    
    private boolean helper(String p, int indexP) {
        for (int i = indexP; i < p.length(); i += 2) {
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                return false;
            }
        }
        return true;
    }
    
}
