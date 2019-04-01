class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.length() == 0 || version2.length() == 0) return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0, index2 = 0;
        while (index1 < v1.length && index2 < v2.length) {
            int num1 = Integer.valueOf(v1[index1]);
            int num2 = Integer.valueOf(v2[index2]);
            
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            } else {
                index1++;
                index2++;
            }
        }
        while (index1 < v1.length) {
            if (Integer.valueOf(v1[index1]) != 0) {
                return 1;
            } else {
                index1++;
            }
        }
        while (index2 < v2.length) {
            if (Integer.valueOf(v2[index2]) != 0) {
                return -1;
            } else {
                index2++;
            }
        }
        return 0;
    }
}
