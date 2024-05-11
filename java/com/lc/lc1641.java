package lc;

import java.util.Arrays;

/**
 * @program: exercise
 * @description: lc1641
 * @author: 郭晨旭
 * @create: 2023-03-29 12:17
 * @version: 1.0
 **/
public class lc1641 {
    // /**
    // * 暴力搜索 + 剪枝优化
    // * 输麻麻
    // */
    // Map<Integer, int[]> map = new HashMap<>();
    //
    // public int countVowelStrings(int n) {
    // for (int i = 0; i < n; ++i) {
    // map.put(i, new int[5]);
    // }
    // return dfs(0, 0, n);
    // }
    //
    // public int dfs(int now, int idx, int n) {
    // if (idx == n) {
    // return 1;
    // }
    // int res = 0;
    // for (int i = now; i < 5; ++i) {
    // if (map.get(idx)[i] == 0) {
    // map.get(idx)[i] = dfs(i, idx + 1, n);
    // }
    // res += map.get(idx)[i];
    // }
    // return res;
    // }

    /**
     * 动态规划
     */
    public int countVowelStrings(int n) {
        int[] dp = { 1, 1, 1, 1, 1 };
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < 5; ++j) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }
}
