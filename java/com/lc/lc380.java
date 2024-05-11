package lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: 郭晨旭
 * @create: 2023-10-31 21:54
 * @version: 1.0
 */
public class lc380 {
    class RandomizedSet {
        int[] nums;
        Map<Integer, Integer> map;
        int idx;

        Random random;

        public RandomizedSet() {
            nums = new int[200005];
            map = new HashMap<>();
            idx = 0;
            random = new Random();
        }

        public boolean insert(int val) {
            if (idx > 0 && map.containsKey(val)) {
                return false;
            }

            nums[idx] = val;
            map.put(val, idx);
            idx++;
            return true;
        }

        public boolean remove(int val) {
            if (idx <= 0 || !map.containsKey(val)) {
                return false;
            }

            nums[map.get(val)] = nums[idx - 1];
            map.put(nums[idx - 1], map.get(val));
            map.remove(val);
            idx--;
            return true;
        }

        public int getRandom() {
            return nums[random.nextInt(idx)];
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
