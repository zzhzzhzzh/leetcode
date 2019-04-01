//普通方法会超时
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 0;
        for (int i = 1; i <= num - 1; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}
//优化方法
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 0;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) sum += num / i;
            }
        }
        sum++;
        return sum == num;
    }
}
