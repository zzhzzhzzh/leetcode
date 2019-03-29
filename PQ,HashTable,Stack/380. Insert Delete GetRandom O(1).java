class RandomizedSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> nums;
    Map<Integer, Integer> num2Index;
    Random rand;
    public RandomizedSet() {
        nums = new ArrayList<>();
        num2Index = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (num2Index.containsKey(val)) {
            return false;
        }
        num2Index.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!num2Index.containsKey(val)) {
            return false;
        }
        if (num2Index.get(val) != nums.size() - 1) {
            int index = num2Index.get(val);
            int last = nums.get(nums.size() - 1);
            num2Index.put(last, index);
            nums.set(index, last);
        }
        nums.remove(nums.size() - 1);
        num2Index.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
