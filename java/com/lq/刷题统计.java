package lq;

import java.util.*;

public class 刷题统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong(), b = scanner.nextLong(), n = scanner.nextLong();
        long x = a * 5 + b * 2;
        long day = n / x;
        long sum = day * x;
        long cnt = 0;
        while (sum < n) {
            sum += (cnt % 7 != 5 && cnt % 7 != 6) ? a : b;
            cnt++;
        }
        System.out.println(day * 7 + cnt);
    }
}