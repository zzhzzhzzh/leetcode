class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, j = 0;
        int maxLen = 1;
        Set<Character> set = new HashSet<>();
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                //System.out.println(j);
                set.add(s.charAt(j));
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            set.remove(s.charAt(i));
        }
        return maxLen;
    }
}
