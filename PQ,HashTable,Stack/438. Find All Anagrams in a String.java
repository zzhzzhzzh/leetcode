class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) return res;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < p.length(); i++) { // initialize map and count
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            count++;
        }
        int i = 0, j = 0;
        int n = p.length();
        
        for (i = 0; i <= s.length() - n; i++) {
            while (j < s.length() && j - i <= n - 1) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
                if (map.get(s.charAt(j)) >= 0) //p contains this character
                    count--;
                j++;
            }

            if (count == 0) res.add(i);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            if (map.get(s.charAt(i)) > 0) { //p contains this character;
                count++;
            }
        }
        return res;
    }
}
