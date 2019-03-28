class FreqStack {

    Map<Integer, Integer> map1;
    Map<Integer, Stack<Integer>> map2;
    int max = 0;
    public FreqStack() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void push(int x) {
        map1.put(x, map1.getOrDefault(x, 0) + 1);
        max = Math.max(max, map1.get(x));
        if (!map2.containsKey(map1.get(x))) {
            map2.put(map1.get(x), new Stack<Integer>());
        }
        map2.get(map1.get(x)).push(x);
    }
    
    public int pop() {
        int res = map2.get(max).pop();
        map1.put(res, map1.get(res) - 1);
        if (map2.get(max).isEmpty()) {
            max--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
