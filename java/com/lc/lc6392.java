package lc;

/**
 * @program: exercise
 * @description: lc6392
 * @author: 郭晨旭
 * @create: 2023-04-23 11:03
 * @version: 1.0
 **/
public class lc6392 {
    public int minOperations(int[] nums) {
        int len = nums.length, cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                ++cnt;
            }
        }
        if (cnt == len) {
            // 全为1, 直接返回0
            return 0;
        } else if (cnt == 0) {
            // 没有1, 则将cnt赋值为1, 防止干扰后面的ans
            cnt = 1;
        }
        int fi = 0, se = 0;
        int ans = 0x7fffffff;
        while (fi < len) {
            // todo 应该可以优化
            int g = nums[fi], temp = fi;
            se = fi;
            while (se < len) {
                g = gcd(g, nums[se]);
                if (g == 1) {
                    // 有cnt个1, 就可以少做cnt-1次操作
                    ans = Math.min(ans, 2 * (se - fi) + len - (se - fi + 1) - cnt + 1);
                    fi = se;
                    g = nums[fi];
                }
                ++se;
            }
            fi = temp + 1;
        }
        return ans != 0x7fffffff ? ans : -1;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
