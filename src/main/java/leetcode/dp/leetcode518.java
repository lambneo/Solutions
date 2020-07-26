package leetcode.dp;

public class leetcode518 {
    /**
     * 与377类似，但需要去重复
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        leetcode518 test = new leetcode518();
        System.out.println(test.change(5, new int[]{1,2,5}));
    }
}
