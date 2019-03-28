class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        max = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
    }
    
    public void addNum(int num) {
        if (min.size() == max.size()) {
            max.offer(num);
        } else {
            min.offer(num);
        }
        if (!min.isEmpty() && min.peek() < max.peek()) {
                int temp = max.poll();
                max.offer(min.poll());
                min.offer(temp);
            }
    }
    
    public double findMedian() {
        if (max.size() > min.size()) {
            return (double)max.peek();
        } else {
            return (max.peek() + min.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
