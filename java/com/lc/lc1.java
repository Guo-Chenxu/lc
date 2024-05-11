package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 郭晨旭
 * @create: 2024-01-09 19:59
 * @version: 1.0
 */
public class lc1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
