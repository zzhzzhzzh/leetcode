
//这题还可以通过binarysearch来做

//two pointers
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
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

//使用hashtable
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         if (nums1.length == 0 || nums2.length == 0) {
//             return new int[0];
//         }
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int num: nums1) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
//         List<Integer> temp = new ArrayList<>();
//         for (int num: nums2) {
//             if (map.containsKey(num)) {
//                 temp.add(num);
//                 map.put(num, map.get(num) - 1);
//                 if (map.get(num) == 0) {
//                     map.remove(num);
//                 }
//             }
//         }
//         int[] res = new int[temp.size()];
//         for (int i = 0; i < temp.size(); i++) {
//             res[i] = temp.get(i);
//         }
//         return res;
//     }
// }
