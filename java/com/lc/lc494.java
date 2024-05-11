package lc;

import java.util.Arrays;

/**
 * @author: 郭晨旭
 * @create: 2023-10-31 21:40
 * @version: 1.0
 */
public class lc494 {
    // todo 不熟
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum || target < -sum || ((sum - target) & 1) != 0) {
            return 0;
        }

        int n = (sum - target) >> 1, len = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = n; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[n];
    }
}