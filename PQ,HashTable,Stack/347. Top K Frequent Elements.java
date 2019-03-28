class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){ // minimum heap
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            } 
        }
        int size = Math.min(k, pq.size());
        for (int i = 0; i < size; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
