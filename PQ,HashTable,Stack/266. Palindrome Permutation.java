class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for (Character ch: map.keySet()) {
            if (map.get(ch) % 2 == 1) {
                oddCount++;
            }
            if (oddCount > 1)
                return false;
        }
        return true;
    }
}
