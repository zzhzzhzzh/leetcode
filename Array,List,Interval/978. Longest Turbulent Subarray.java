class Solution {
    public int maxTurbulenceSize(int[] A) {
        int ans = 1;
        int anchor = 0;
        for (int i = 1 ; i < A.length; i++) {
            int c = Integer.compare(A[i], A[i - 1]);
            if (c == 0) {
                anchor = i;
            } else if (i == A.length - 1 || c * (Integer.compare(A[i + 1], A[i])) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }
        return ans;
    }
}
