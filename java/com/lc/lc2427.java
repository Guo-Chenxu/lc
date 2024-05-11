package lc;

/**
 * @program: exercise
 * @description: lc2427
 * @author: 郭晨旭
 * @create: 2023-04-05 09:28
 * @version: 1.0
 **/
public class lc2427 {
    public int commonFactors(int a, int b) {
        int x = gcd(a, b);
        int count = 0, num = 1;
        while (num * num <= x) {
            int temp = x / num;
            if (temp * num == x) {
                count += 2;
                if (temp == num) {
                    --count;
                }
            }
            ++num;
        }
        return count;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
