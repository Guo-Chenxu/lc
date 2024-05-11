package lc;

/**
 * @program: exercise
 * @description: lc1027
 * @author: 郭晨旭
 * @create: 2023-04-22 09:07
 * @version: 1.0
 **/
public class lc1027 {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][1001];
        int res = 0;
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = dp[j][d] + 1;
                res = Math.max(res, dp[i][d]);
            }
        }
        return res + 1;
    }
}
