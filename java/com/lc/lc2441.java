package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: exercise
 * @description: lc2441
 * @author: 郭晨旭
 * @create: 2023-05-13 11:02
 * @version: 1.0
 **/
public class lc2441 {
    public int findMaxK(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(-num)) {
                res = Math.max(res, Math.abs(num));
            }
            map.put(num, 1);
        }
        return res == 0 ? -1 : res;
    }

    public int findMaxK01(int[] nums) {
        int res = 0;
        boolean[] has = new boolean[2001];
        for (int num : nums) {
            has[num + 1000] = true;
            if (has[1000 - num]) {
                res = Math.max(res, Math.abs(num));
            }
        }
        return res == 0 ? -1 : res;
    }
}
