package lc;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class lc2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; ++i) {
            queries[i] = search(nums, queries[i]);
        }
        return queries;
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = ((l + r) >> 1);
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
