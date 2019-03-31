public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return quickSelect(n, nums, 0, nums.length - 1);
    }
    private int quickSelect(int n, int[] nums, int start, int end) {
        if (start >= end) return nums[start];
        int left = start, right = end;
        int pivot = nums[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (start + n -1 <= right) {
            return quickSelect(n, nums, start, right);
        } else if (start + n-1 >= left) {
            return quickSelect(n - (left - start), nums, left, end);
        } else {
            return nums[right + 1];
        }
    }
}
