package leetCodes;

public class Interview49 {
    /**
     * Ugly number
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i1 = 0, i2 = 0, i3 = 0;
        dp[0] = 1;
        if (n <= 6)
            return n;
        for (int i = 1; i < n; i++) {
            int next2 = 2 * dp[i1], next3 = 3 * dp[i2], next5 = 5 * dp[i3];
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2)
                i1++;
            if (dp[i] == next3)
                i2++;
            if (dp[i] == next5)
                i3++;
        }
        return dp[n - 1];

    }

}
