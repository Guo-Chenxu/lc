package lc;

/**
 * @program: exercise
 * @description: lc1017
 * @author: 郭晨旭
 * @create: 2023-04-06 10:26
 * @version: 1.0
 **/
public class lc1017 {
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int x = n & 1;
            res.append(x);
            n = n - x;
            n = n / 2;
        }
        return res.reverse().toString();
    }
}
