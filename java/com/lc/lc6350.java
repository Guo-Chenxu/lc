package lc;

/**
 * @program: exercise
 * @description: lc6350
 * @author: 郭晨旭
 * @create: 2023-04-16 10:36
 * @version: 1.0
 **/
public class lc6350 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = divisors[0], cnt = 0;
        int m = nums.length, n = divisors.length;
        for (int divisor : divisors) {
            int temp = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    ++temp;
                }
            }
            if (temp > cnt) {
                cnt = temp;
                ans = divisor;
            } else if (temp == cnt && divisor < ans) {
                ans = divisor;
            }
        }
        return ans;
    }
}
