package leetcode.dp;

public class leetcode377 {
    /**
     * 与518对比，完全背包,需要考虑顺序问题
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num)
                dp[i] = dp[i] + dp[i - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        leetcode377 test = new leetcode377();
        System.out.println(test.combinationSum4(new int[]{1,2,3}, 5));
    }
}
