package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: exercise
 * @description: lc6360
 * @author: 郭晨旭
 * @create: 2023-04-09 11:03
 * @version: 1.0
 **/
public class lc6360 {
    // todo 时间复杂度太高
    // 似乎也只能这样了
    public long[] distance(int[] nums) {
        int len = nums.length;
        long[] ans = new long[len];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            int n = list.size();
            long[] pre = new long[n + 1];
            for (int i = 1; i <= n; ++i) {
                pre[i] = pre[i - 1] + (long) list.get(i - 1);
            }
            for (int i = 1; i <= n; ++i) {
                ans[list.get(i - 1)] = (long) (i - 1) * list.get(i - 1) - pre[i - 1]
                        + (pre[n] - pre[i] - (long) (n - i) * list.get(i - 1));
            }
        }
        return ans;
    }
}
