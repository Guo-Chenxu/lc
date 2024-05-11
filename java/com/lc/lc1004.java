package lc;

/**
 * @program: exercise
 * @description: lc1004
 * @author: 郭晨旭
 * @create: 2023-04-09 15:16
 * @version: 1.0
 **/
public class lc1004 {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int ans = 0, cnt = 0;
        int l = 0, r = 0;
        for (; r < len; ++r) {
            if (nums[r] == 0) {
                ++cnt;
            }
            while (cnt > k) {
                if (nums[l++] == 0) {
                    --cnt;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
