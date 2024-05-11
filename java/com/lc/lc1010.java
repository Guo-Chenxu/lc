package lc;

/**
 * @program: exercise
 * @description: lc1010
 * @author: 郭晨旭
 * @create: 2023-05-07 11:43
 * @version: 1.0
 **/
public class lc1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mod = new int[60];
        for (int t : time) {
            ++mod[t % 60];
        }
        int res = 0;
        res += combination(mod[30], 2);
        res += combination(mod[0], 2);
        for (int i = 1; i < 30; ++i) {
            res += mod[i] * mod[60 - i];
        }
        return res;
    }

    public int combination(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; ++i) {
            res = res * (n - i + 1) / i;
        }
        return (int) res;
    }
}
