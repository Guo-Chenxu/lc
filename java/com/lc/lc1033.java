package lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: exercise
 * @description: lc1033
 * @author: 郭晨旭
 * @create: 2023-04-30 11:37
 * @version: 1.0
 **/
public class lc1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(Math.min(a, b), c);
        int z = Math.max(Math.max(a, b), c);
        int y = a + b + c - x - z;
        int min = 2, max = z - x - 2;
        if (z - y == 1 && y - x == 1) {
            min = 0;
        } else if (z - y <= 2 || y - x <= 2) {
            min = 1;
        }
        return new int[] { min, max };
    }
}
