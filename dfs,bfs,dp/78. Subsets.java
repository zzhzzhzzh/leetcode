class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        dfs(0, nums, new ArrayList<Integer>(), res);
        return res;
    }
    public void dfs(int startIndex, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(subset));
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(i + 1, nums, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
