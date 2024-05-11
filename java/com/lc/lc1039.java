package lc;

/**
 * @program: exercise
 * @description: lc1039
 * @author: 郭晨旭
 * @create: 2023-04-02 11:14
 * @version: 1.0
 **/
public class lc1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 3; len <= n; ++len) {
            for (int l = 0; l + len - 1 < n; ++l) {
                int r = l + len - 1;
                dp[l][r] = 0x7fffffff;
                for (int k = l + 1; k < r; ++k) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + values[l] * values[k] * values[r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
