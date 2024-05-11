package lc;

/**
 * @program: exercise
 * @description: lc6390
 * @author: 郭晨旭
 * @create: 2023-04-23 10:34
 * @version: 1.0
 **/
public class lc6390 {
    // 桶排序 + 偏移值 保存所有数字
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] sort = new int[200];
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int fi = 0, se = 0, idx = 0;
        for (; se < k; ++se) {
            ++sort[nums[se] + 50];
        }
        ans[idx++] = search(sort, x);
        while (se < n) {
            --sort[nums[fi++] + 50];
            ++sort[nums[se++] + 50];
            ans[idx++] = search(sort, x);
        }
        return ans;
    }

    public int search(int[] sort, int x) {
        int cnt = 0;
        for (int i = 0; i < 50; ++i) {
            cnt += sort[i];
            if (cnt >= x) {
                return i - 50;
            }
        }
        return 0;
    }
}
