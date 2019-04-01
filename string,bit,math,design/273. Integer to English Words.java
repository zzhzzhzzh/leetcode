class Solution {
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] Less_Than_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] Thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        String word = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + Thousands[i] + " " + word;   
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }
    public String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return Less_Than_20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return Less_Than_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}

//判断一个数是不是平方数
public boolean isSquare(int num) {
    int i = 1;
    while (num > 0) {
        num -= i;
        i += 2;
        if (num == 0) return true;
    }
    return false;
}
