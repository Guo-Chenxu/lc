package lc;

import java.util.*;

public class lc2488 {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int idx = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        map.put(sum, 1);
        for (int i = 0; i < n; ++i) {
            if (nums[i] > k) {
                sum += 1;
            } else if (nums[i] < k) {
                sum -= 1;
            } else {
                idx = i;
                int count = map.getOrDefault(sum, 0);
                map.put(sum, count + 1);
            }
            if (idx == -1) {
                int count = map.getOrDefault(sum, 0);
                map.put(sum, count + 1);
            } else {
                ans += map.getOrDefault(sum, 0);
                ans += map.getOrDefault(sum - 1, 0);
            }
        }
        return ans;
    }
}
