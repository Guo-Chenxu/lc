package lc;

/**
 * @program: exercise
 * @description: lc1015
 * @author: 郭晨旭
 * @create: 2023-05-10 10:05
 * @version: 1.0
 **/
public class lc1015 {
    public int smallestRepunitDivByK(int k) {
        int len = 1, r = 1 % k;
        int[] map = new int[k];
        while (r != 0) {
            r = (r * 10 + 1) % k;
            if (map[r] != 0) {
                return -1;
            }
            ++map[r];
            ++len;
        }
        return len;
    }

    public int smallestRepunitDivByK01(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int len = 1, x = 1 % k;
        while (x != 0) {
            x = (x * 10 + 1) % k;
            ++len;
        }
        return len;
    }
}
