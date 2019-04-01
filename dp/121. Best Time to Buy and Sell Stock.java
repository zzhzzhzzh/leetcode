//输出股票买卖在哪一天, 输出坐标版本
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] res = new int[2];
        int min = prices[0];
        int curt;
        int maxProfit = 0;
        int minIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            curt = prices[i];
            //maxProfit = Math.max(curt - min, maxProfit);
            if (maxProfit < curt - min) {
                maxProfit = curt - min;
                res[0] = minIndex;
                res[1] = i;
            }
            //min = Math.min(min, prices[i]); 
            if (min > prices[i]) {
                min = prices[i];
                minIndex = i;
            }
        }
        System.out.println(res[0]);
        
        System.out.println(res[1]);
        return maxProfit;
    }
}



// class Solution {
//     public int maxProfit(int[] prices) {
//         if (prices.length == 0) return 0;
//         int min = prices[0];
//         int curt;
//         int maxProfit = 0;
//         for (int i = 0; i < prices.length; i++) {
//             curt = prices[i];
//             maxProfit = Math.max(curt - min, maxProfit);
//             min = Math.min(min, prices[i]);
//         }
//         return maxProfit;
//     }
// }

