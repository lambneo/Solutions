package leetcode.dp;

import java.util.Arrays;

/**
 * 路径数
 */
public class leetcode62{
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    //加障碍物版本
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) continue;
                if (i == 0 || j == 0)
                    dp[j] = i == 0 ? dp[j - 1] : dp[j];
                else dp[j] = dp[j - 1] + dp[j];
            }

        }

        return dp[n - 1];
    }
}
