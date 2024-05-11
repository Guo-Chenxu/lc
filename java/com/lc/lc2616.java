package lc;

import java.util.Arrays;

/**
 * @program: exercise
 * @description: lc2616
 * @author: 郭晨旭
 * @create: 2023-04-09 11:35
 * @version: 1.0
 **/
public class lc2616 {
    // 思路: 先排序, 再二分答案, O(nlogn)
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int min = 0, max = 1_000_000_000;
        while (min < max) {
            int mid = (min + max) / 2;
            if (count(nums, mid) < p) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private long count(int[] nums, int target) {
        int res = 0;
        int pos = 0;
        while (pos + 1 < nums.length) {
            if (nums[pos + 1] - nums[pos] <= target) {
                ++res;
                ++pos;
            }
            ++pos;
        }
        return res;
    }
}
