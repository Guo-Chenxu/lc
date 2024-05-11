package lq;

import java.util.*;

public class 最大公约数和最小公倍数问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        long x = Long.parseLong(split[0]), y = Long.parseLong(split[1]);
        if (y % x != 0) {
            System.out.println(0);
            return;
        }
        long all = y / x, res = 0;
        long sqrt = (long) Math.sqrt(all);
        for (long i = 1; i <= sqrt; i++) {
            if (all % i == 0) {
                if (i == sqrt && i * x == y) {
                    // 只有两数等于最小公倍数的时候才会成立,
                    // 比如 2 8 会分出来 4 4, 满足 i==sqrt, 但是他们的最小公倍数是4, 不符合题意
                    res += 1;
                } else if (gcd(i, all / i) == 1) {
                    res += 2;
                }
            }
        }
        System.out.println(res);
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
