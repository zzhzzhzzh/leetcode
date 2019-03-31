class Solution {
    List<List<Integer>> res;
    int first;
    int second;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new ArrayList<>();
        if (nums == null || nums.length <= 3) return res;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int newTarget = target - nums[i];
            first = nums[i];
            threeSum(nums, i+1, newTarget);
        }
        return res;
    }
    public void threeSum(int[] nums, int startIndex, int target) {
        for (int i = startIndex; i < nums.length - 2; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            int newTarget = target - nums[i];
            second = nums[i];
            twoSum(nums, i + 1, newTarget);
        }
    }
    public void twoSum(int[] nums, int startIndex, int target) {
        int left = startIndex, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> quadruplet = new ArrayList<>();
                quadruplet.add(first);
                quadruplet.add(second);
                quadruplet.add(nums[left]);
                quadruplet.add(nums[right]);
                res.add(quadruplet);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
