I saw some people asking why this algorithm is correct. Here is my understanding. Hope it helps.

Proof: Suppose this algorithm works, i.e. for each position j (starting from 0), the probability of any number in the range[0,j] to be at position j is 1/(1+j).

Let's look at int i = random.nextInt(j + 1):
(1) If i == j, nums[j] does not need to change its position, which has probability 1/(1+j).
(2) if i !=j, nums[j] needs to be swapped with nums[i]. The probability of any number x in the range [0,j-1] to be at position j = nums[j] changes its position * x is at position i
= (1-1/(1+j)) * (1/j) = 1/(1+j)

Each number has equal probability to be at any position.

class Solution {

    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;    
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] a = nums.clone();
        for (int j = 0; j < a.length; j++) {
            int i = rand.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
