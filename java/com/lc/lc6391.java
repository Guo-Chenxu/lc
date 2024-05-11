package lc;

/**
 * @program: exercise
 * @description: lc6391
 * @author: 郭晨旭
 * @create: 2023-04-23 10:32
 * @version: 1.0
 **/
public class lc6391 {
    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0) {
                res += i;
            } else if (i % 5 == 0) {
                res += i;
            } else if (i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}
