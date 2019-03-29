class Solution {
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
