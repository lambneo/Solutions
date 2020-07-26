package leetcode.dp;

public class leetcode416 {
    /**
     * 判断数组是否可以被分成两部分，两部分和相等
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int target = sum / 2, len = nums.length;

        if ((sum & 1) == 1) return false;

        boolean[][] dp = new boolean[len][target + 1];

        if (nums[0] <= target) dp[0][nums[0]] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j == nums[i]) dp[i][j] = true;

                if (nums[i] < j) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        }

        return dp[len - 1][target];
    }
}
