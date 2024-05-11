package lc;

/**
 * @program: exercise
 * @description: lc1043
 * @author: 郭晨旭
 * @create: 2023-04-19 10:49
 * @version: 1.0
 **/
public class lc1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len + 1];
        int max = arr[0];
        for (int i = 0; i < k; ++i) {
            max = Math.max(max, arr[i]);
            dp[i] = (i + 1) * max;
        }
        for (int i = k; i < len; ++i) {
            max = arr[i];
            for (int j = 1; j <= k; ++j) {
                max = Math.max(max, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], dp[i - j] + j * max);
            }
        }
        return dp[len - 1];
    }
}
