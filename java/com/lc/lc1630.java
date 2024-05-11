package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: exercise
 * @description: lc1630
 * @author: 郭晨旭
 * @create: 2023-03-23 10:14
 * @version: 1.0
 **/
public class lc1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            ans.add(check(nums, l[i], r[i]));
        }
        return ans;
    }

    public Boolean check(int[] nums, int l, int r) {
        int max = nums[l], min = nums[l];
        for (int i = l + 1; i <= r; ++i) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        if (max == min) {
            return true;
        }
        if ((max - min) % (r - l) != 0) {
            return false;
        }
        int[] count = new int[l - r + 1];
        int d = (max - min) / (r - l);
        for (int i = l; i <= r; ++i) {
            int x = (nums[i] - min) / d;
            if ((nums[i] - min) % d != 0 || count[x] > 0) {
                return false;
            }
            ++count[x];
        }
        return true;
    }
}
