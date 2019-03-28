public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,
                                        new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        for (int num: nums) {
                pq.offer(num);
                if (pq.size() > k) 
                    pq.poll();
            }
            int[] res = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                res[i] = pq.poll();
            }
            return res;
    }
}
