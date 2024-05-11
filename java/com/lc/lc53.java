package lc;

public class lc53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], cur = 0;
        for (int num : nums) {
            cur += num;
            ans = Math.max(ans, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return ans;
    }
}
