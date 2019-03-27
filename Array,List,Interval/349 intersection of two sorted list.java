
// 不用hashmap的版本
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0, index = 0;
        int[] temp = new int[nums2.length];
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                if (index > 0 && nums1[index1] == temp[index-1]) {
                    index1++;
                    index2++;
                    continue;
                }
                temp[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        int[] res = new int[index];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp[i];
        }
        return res;
    }
}

/**
used one hashset 
*/
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         if (nums1.length == 0 || nums2.length == 0) return new int[0];
//         Set<Integer> set = new HashSet<>();
//         for (int num: nums1) {
//             set.add(num);
//         }
//         int[] temp = new int[nums2.length];
//         int index = 0;
//         for (int num: nums2) {
//             if (set.contains(num)) {
//                 temp[index++] = num;
//                 set.remove(num);
//             }
//         }
//         int[] res = new int[index];
//         for (int i = 0; i < res.length; i++) {
//             res[i] = temp[i];
//         }
//         return res;
//     }
// }
