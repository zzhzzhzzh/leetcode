class Solution {
    public int trap(int[] height) {
        int left = 0 , right = height.length - 1;
        int res = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left + 1] < height[left]) {
                    res += height[left] - height[left + 1];
                    height[left + 1] = height[left];
                }
                left++;
            } else {
                if (height[right] > height[right - 1]) {
                    res += height[right] - height[right - 1];
                    height[right - 1] = height[right];
                }
                right--;
            }
        }
        return res;
    }
}
