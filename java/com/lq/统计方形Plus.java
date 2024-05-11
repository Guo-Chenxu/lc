package lq;

import java.util.*;

public class 统计方形Plus {
    public static void main(String[] args) {
        String[] split = new Scanner(System.in).nextLine().split(" ");
        long m = Long.parseLong(split[0]), n = Long.parseLong(split[1]);
        long a = 0, b = 0;
        for (long i = 1; i <= m; i++) {
            for (long j = 1; j <= n; j++) {
                a += Math.min(i, j);
                b += i * j;
            }
        }
        System.out.println(a + " " + (b - a));
    }
}
