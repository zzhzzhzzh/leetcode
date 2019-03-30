class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        Set<String> dict = new HashSet<>();
        for (String str: wordDict) {
            dict.add(str);
        }
        boolean[] visited = new boolean[s.length()];
        boolean[] memo = new boolean[s.length()];
        return dfs(s, 0, dict, visited, memo);
    }
    public boolean dfs(String s, int startIndex, Set<String> dict, boolean[] visited, boolean[] memo) {
        if (dict.contains(s.substring(startIndex))) {
            return true;
        }
        if (visited[startIndex]) {
            return memo[startIndex];
        }
        boolean match = false;
        for (int i = startIndex + 1; i < s.length(); i++) {
            if (dict.contains(s.substring(startIndex, i))) {
                match = dfs(s, i, dict, visited, memo);
                if (match) {
                    memo[startIndex] = match;
                }
            }
        }
        visited[startIndex] = true;
        return memo[startIndex];
    }
}
