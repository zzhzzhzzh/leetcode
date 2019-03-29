//
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String string = String.valueOf(ch);
            if (!map.containsKey(string)) map.put(string, new ArrayList<String>());
            map.get(string).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}




// brute force  n^2
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < strs.length; i++) {
            if (set.contains(strs[i])) continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            set.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    set.add(strs[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            char cc = t.charAt(j);
            map[cc - 'a']--;
        }
        for (int k = 0; k < 26; k++) {
            if (map[k] != 0) {
                return false;
            }
        }
        return true;
    }
}
