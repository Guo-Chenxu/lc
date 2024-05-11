package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: exercise
 * @description: lc2395
 * @author: 郭晨旭
 * @create: 2023-03-26 11:54
 * @version: 1.0
 **/
public class lc2395 {
    public boolean findSubarrays(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < len; ++i) {
            int x = nums[i] + nums[i - 1];
            if (map.containsKey(x)) {
                return true;
            } else {
                map.put(x, 1);
            }
        }
        return false;
    }
}
