package lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: exercise
 * @description: lc970
 * @author: 郭晨旭
 * @create: 2023-05-02 10:16
 * @version: 1.0
 **/
public class lc970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        int a = 1;
        for (int i = 0;; ++i) {
            int b = 1;
            if (a + 1 > bound) {
                break;
            }
            for (int j = 0;; ++j) {
                if (a + b <= bound) {
                    set.add(a + b);
                } else {
                    break;
                }
                if (y == 1) {
                    break;
                }
                b *= y;
            }
            if (x == 1) {
                break;
            }
            a *= x;
        }
        return new ArrayList<>(set);
    }
}
