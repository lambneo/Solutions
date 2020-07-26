package leetcode.dp;

import java.util.Arrays;

public class leetcode322 {
    /**
     * 完全背包 因为是求最小值
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }



    public static void main(String[] args) {
        leetcode322 test = new leetcode322();
        System.out.println(test.coinChange(new int[] {1,2,5}, 11));
    }

}

