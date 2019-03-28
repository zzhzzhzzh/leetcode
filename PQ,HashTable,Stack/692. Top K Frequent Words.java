class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>(){
            public int compare(String a, String b) {
                int diff = map.get(a) - map.get(b);
                if (diff == 0) {
                    diff = b.compareTo(a);
                }
                return diff;
            }
        });
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry.getKey());
            } else {
                pq.offer(entry.getKey());
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(0, pq.poll());
        }
        return res;
    }
}
