class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            x = 1/x;
            n = -(n + 1);
        }
        double ans = 1, temp = x;
        while (n != 0) {
            if (n % 2 == 1) {
                ans *= temp;
            }
            temp *= temp;
            n = n/2;
        }
        if (isNegative) {
            ans *= x;
        }
        return ans;
    }
}
