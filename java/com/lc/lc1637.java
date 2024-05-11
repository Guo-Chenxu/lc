package lc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: exercise
 * @description: lc1637
 * @author: 郭晨旭
 * @create: 2023-03-30 12:29
 * @version: 1.0
 **/
public class lc1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int len = points.length, res = 0;
        for (int i = 1; i < len; ++i) {
            res = Math.max(res, points[i][0] - points[i - 1][0]);
        }
        return res;
    }
}
