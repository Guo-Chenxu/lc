package lc;

import java.util.Arrays;

/**
 * @program: exercise
 * @description: lc2418
 * @author: 郭晨旭
 * @create: 2023-04-25 10:29
 * @version: 1.0
 **/
public class lc2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[][] h = new int[n][2];
        for (int i = 0; i < n; ++i) {
            h[i][0] = heights[i];
            h[i][1] = i;
        }
        Arrays.sort(h, (o1, o2) -> o2[0] - o1[0]);
        String[] res = new String[n];
        for (int i = 0; i < n; ++i) {
            res[i] = names[h[i][1]];
        }
        return res;
    }
}
