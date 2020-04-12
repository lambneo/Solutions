package leetCodes;

/**
 * 股票最大收益，简单动态规划
 */
public class Interview63 {
    public int maxProfit(int[] prices) {
        int max = 0, n = prices.length;
        if (prices.length <= 1) return max;
        int minBuyin = prices[0];
        for (int i = 1; i < n; i++){
            if (prices[i] > minBuyin)
                max = Math.max(max, prices[i] - minBuyin);
            minBuyin = Math.min(minBuyin, prices[i]);

        }
        return max;
    }
}
