package lc;

/**
 * @program: exercise
 * @description: lc2367
 * @author: 郭晨旭
 * @create: 2023-03-31 13:47
 * @version: 1.0
 **/
public class lc2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length, end = nums[len - 1];
        boolean[] n = new boolean[end + 1];
        for (int num : nums) {
            n[num] = true;
        }
        int res = 0;
        end = end - diff - diff;
        for (int i = 0; i <= end; ++i) {
            if (n[i] && n[i + diff] && n[i + diff + diff]) {
                ++res;
            }
        }
        return res;
    }
}
