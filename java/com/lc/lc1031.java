package lc;

/**
 * @program: exercise
 * @description: lc1031
 * @author: 郭晨旭
 * @create: 2023-04-26 10:34
 * @version: 1.0
 **/
public class lc1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; ++i) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        return Math.max(func(preSum, firstLen, secondLen), func(preSum, secondLen, firstLen));
    }

    public int func(int[] preSum, int len1, int len2) {
        int res = 0, maxL = 0;
        int len = preSum.length;
        for (int i = len1 + len2; i < len; ++i) {
            maxL = Math.max(maxL, preSum[i - len2] - preSum[i - len2 - len1]);
            res = Math.max(res, maxL + preSum[i] - preSum[i - len2]);

        }
        return res;
    }
}
