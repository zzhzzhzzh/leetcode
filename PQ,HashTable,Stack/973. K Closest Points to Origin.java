class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        if (points.length == 0 || points[0].length == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){ // construct a maximum heap
            public int compare(int[] a, int[] b) {
                int diff = getDistance(b) - getDistance(a);
                if (diff == 0) {
                    diff = b[0] - a[0];
                }
                if (diff == 0) {
                    diff = b[1] - a[1];
                }
                return diff;
            }
        });
        for (int[] point: points) {
            pq.offer(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int size= Math.min(pq.size(), K);
        for (int i = 0; i < size; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
    
    public int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
