class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            queue.offer(c);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (map.get(c) == 1) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
