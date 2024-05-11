package lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @program: exercise
 * @description: lc1626
 * @author: 郭晨旭
 * @create: 2023-03-22 09:03
 * @version: 1.0
 **/
public class lc1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] ordered = new int[len][2];
        for (int i = 0; i < len; ++i) {
            ordered[i][0] = ages[i];
            ordered[i][1] = scores[i];
        }
        Arrays.sort(ordered, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int[] dp = new int[len + 1];
        dp[0] = ordered[0][1];
        int res = 0;
        for (int i = 1; i < len; ++i) {
            dp[i] = ordered[i][1];
            for (int j = 0; j < i; ++j) {
                if (ordered[j][1] <= ordered[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + ordered[i][1]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
