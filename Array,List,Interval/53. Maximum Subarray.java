//输出坐标的版本
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        map.put(0, -1);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int diff = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, i);
            if (diff < sum - min) {
                diff = sum - min;
                res[0] = map.get(min) + 1;
                res[1] = i;
            }
            min = Math.min(min, sum);
            
            
        }
        System.out.print(res[0]);
        System.out.println(res[1]);
        return 0;
        
    }
}

//输出值的版本
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = 0;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum - min);
            min = Math.min(min, sum);
        }
        return res;
        
    }
}

//folow up divide conquer
