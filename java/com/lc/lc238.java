package lc;

public class lc238 {
    // public int[] productExceptSelf(int[] nums) {
    // int[] pre = new int[nums.length + 1], last = new int[nums.length + 1], ans =
    // new int[nums.length];
    // pre[0] = last[nums.length] = 1;
    // for (int i = 0; i < nums.length; i++) {
    // pre[i + 1] = pre[i] * nums[i];
    // }
    // for (int i = nums.length - 1; i >= 0; i--) {
    // last[i] = last[i + 1] * nums[i];
    // }

    // for (int i = 1; i <= nums.length; i++) {
    // ans[i - 1] = pre[i - 1] * last[i];
    // }
    // return ans;
    // }
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= r;
            r *= nums[i];
        }
        return ans;
    }
}
