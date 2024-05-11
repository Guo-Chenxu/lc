package lq;

import java.util.*;

public class 求和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n + 1], pre = new long[n + 1];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long t = scanner.nextLong();
            sum += t;
            nums[i] = t;
            pre[i] = sum;
        }
        long res = 0;
        for (int i = n - 1; i > 0; i--) {
            res += nums[i] * pre[i - 1];
        }
        System.out.println(res);
    }
}
