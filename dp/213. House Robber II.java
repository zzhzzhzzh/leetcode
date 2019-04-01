class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
        return 0; 
 
    if(nums.length==1)
        return nums[0];
 
    int max1 = robHelper(nums, 0, nums.length-2);
    int max2 = robHelper(nums, 1, nums.length-1);
 
    return Math.max(max1, max2);
    }
    
    public int robHelper(int[] nums, int i, int j){
    if(i==j){
        return nums[i];
    }
 
    int[] dp = new int[nums.length];
    dp[i]=nums[i];
    dp[i+1]=Math.max(nums[i+1], dp[i]);
 
    for(int k=i+2; k<=j; k++){
        dp[k]=Math.max(dp[k-1], dp[k-2]+nums[k]);    
    }
    return dp[j];
}
}

//滚动数组优化
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];   
        }
        return Math.max(robber(nums, 0, nums.length - 2), robber(nums, 1, nums.length - 1));
    }
    public int robber(int[] nums, int st, int ed) {
        int[] res = new int[2];
        if(st == ed) {
            return nums[st];
        }
        if(st + 1 == ed) {
            return Math.max(nums[st], nums[ed]);
        }
        res[st % 2] = nums[st];
        res[(st+1) % 2] = Math.max(nums[st], nums[st + 1]);
        
        for(int i = st + 2; i <= ed; i++) {
            res[i % 2] = Math.max(res[(i-1) % 2], res[(i-2)%2] + nums[i]);
        }
        return res[ed % 2];
    }
}
