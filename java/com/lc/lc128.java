package lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: 郭晨旭
 * @create: 2024-01-09 19:11
 * @version: 1.0
 */
public class lc128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int temp = 1, n = num;
                while (set.contains(n + 1)) {
                    temp++;
                    n++;
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}
