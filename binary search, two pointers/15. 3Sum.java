class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            twoSum(nums, i + 1, target);
        }
        return res;
    }
    public void twoSum(int[] nums, int startIndex, int target) {
        int left = startIndex, right = nums.length - 1;
        while (left < right) {
            
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                res.add(triple);
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
