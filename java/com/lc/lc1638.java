package lc;

/**
 * @program: exercise
 * @description: lc1638
 * @author: 郭晨旭
 * @create: 2023-03-27 08:39
 * @version: 1.0
 **/
public class lc1638 {
    public int countSubstrings(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int m = ss.length, n = tt.length;
        int[][] dpl = new int[m + 1][n + 1];
        int[][] dpr = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dpl[i + 1][j + 1] = (ss[i] == tt[j] ? dpl[i][j] + 1 : 0);
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                dpr[i][j] = (ss[i] == tt[j] ? dpr[i + 1][j + 1] + 1 : 0);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ss[i] != tt[j]) {
                    ans = ans + (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }
}
