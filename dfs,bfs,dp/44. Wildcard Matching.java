class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return true;
        
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];
        return dfs(s, 0, p, 0, visited, memo);
    }
    public boolean dfs(String s, int indexS, String p, int indexP, boolean[][] visited, boolean[][] memo) {
        if (indexP == p.length()) {
            return indexS == s.length();
        }
        if (s.length() == indexS) {
            return isEmpty(p, indexP);
        }
        if (visited[indexS][indexP]) {
            return memo[indexS][indexP];
        }
        boolean match = false;
        char sChar = s.charAt(indexS);
        char pChar = p.charAt(indexP);
        
        if (pChar == '*') {
            match = dfs(s, indexS, p, indexP + 1, visited, memo) || dfs(s, indexS + 1, p, indexP, visited, memo);
        } else if (isMatch(sChar, pChar)){
            match = dfs(s, indexS+1, p, indexP + 1, visited, memo);
        }
        visited[indexS][indexP] = true;
        memo[indexS][indexP] = match;
        return match;
    }
    public boolean isEmpty(String p, int indexP) {
        for (int i = indexP; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    public boolean isMatch(char sChar, char pChar) {
        return sChar == pChar || pChar == '?';
    }
}
