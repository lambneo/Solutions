package leetcode.dp;

public class leetcode64 {
    /**
     * 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 || j == 0) {
                    dp[j] = i == 0 ? dp[j - 1] : dp[j];
                } else
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                dp[j] += grid[i][j];
            }
        }

        return dp[dp.length - 1];
    }

}
