package lc;

import java.util.Arrays;

/**
 * @program: exercise
 * @description: lc6376
 * @author: 郭晨旭
 * @create: 2023-04-16 10:32
 * @version: 1.0
 **/
public class lc6376 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int[] ans = new int[2];
        for (int i = 0; i < m; ++i) {
            int temp = Arrays.stream(mat[i]).sum();
            if (temp > ans[1]) {
                ans[0] = i;
                ans[1] = temp;
            }
        }
        return ans;
    }
}
