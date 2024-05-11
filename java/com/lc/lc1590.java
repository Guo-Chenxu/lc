package lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1590 {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        int[] preSum = new int[len];
        preSum[0] = nums[0] % p;
        for (int i = 1; i < len; ++i) {
            preSum[i] = (preSum[i - 1] + nums[i]) % p;
        }
        int target = preSum[len - 1];
        if (target == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = len;
        for (int i = 0; i < len; ++i) {
            map.put(preSum[i], i);
            int t = (preSum[i] - target + p) % p;
            res = Math.min(res, i - map.getOrDefault(t, -len));
        }
        return res == len ? -1 : res;
    }
}
