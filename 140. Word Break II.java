class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, dict, memo);
    }
    public List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        if (dict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String word = s.substring(0, i);
            if (!dict.contains(word)) continue;
            String suffix = s.substring(i);
            List<String> segmentations = dfs(suffix, dict, memo);
            for (String segmentation: segmentations) {
                res.add(word + " " + segmentation);
            }
        }
        memo.put(s, res);
        return res;
    }
}
