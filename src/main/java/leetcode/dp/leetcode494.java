package leetcode.dp;

import org.springframework.context.support.SimpleThreadScope;

public class leetcode494 {
    /**
     * 暴力dfs和动态规划：
     * 将数组分为正数和负数两部分，进行如下推导：
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * 问题转化为一个背包问题
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S){
//        return dfs(nums, 0, S);
        return backpack(nums, S);
    }


    int dfs(int[] nums, int start, int S) {
        if (start == nums.length)
            return S == 0 ? 1 : 0;
        return dfs(nums, start + 1, S - nums[start]) + dfs(nums, start + 1, S + nums[start]);
    }

    int backpack(int[] nums, int S) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int len = nums.length;
        if (((S + sum) & 1) == 1 || sum < S) return 0;
        int W = (S + sum)/2;
        int[]dp = new int[W+1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            for (int j = W; j >= nums[i-1]; j--) {
                dp[j] = dp[j] + dp[j - nums[i-1]];
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        leetcode494 test = new leetcode494();
        System.out.println(test.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
