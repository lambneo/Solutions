package leetCodes;

/**
 * dp中等
 */
public class Interview60 {
    public double[] twoSum(int n) {
        double[] ans = new double[5*n+1];
        int[][] dp = new int[n+1][6*n+1];
        double root = Math.pow(6, n);
        for (int i = 1; i <= 6; i++){
            dp[1][i] = 1;
            ans[i-1] = 1/6.0;
        }
        if (n==1) return ans;

        for (int i = 2; i <= n; i++){
            for (int j = i; j <= 6*i; j++){
                for (int k = 1; k <= 6; k++){
                    dp[i][j] += j>k?dp[i-1][j-k]:0;
                }
            }
        }

        for (int i = 1; i <= ans.length; i++){
            ans[i-1] = dp[n][n+i-1]/root;
        }
        return ans;
    }

    public static void main(String[] args) {
        Interview60 test = new Interview60();
        System.out.print(test.twoSum(2));
    }
}
