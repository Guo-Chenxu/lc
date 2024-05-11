package lq;

import java.util.*;

public class X进制减法 {

    static long mod = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        int n1 = scanner.nextInt();
        long[] num1 = new long[n1];
        for (int i = n1 - 1; i >= 0; i--) {
            num1[i] = scanner.nextLong();
        }
        int n2 = scanner.nextInt();
        long[] num2 = new long[n2];
        for (int i = n2 - 1; i >= 0; i--) {
            num2[i] = scanner.nextLong();
        }

        long carry = 1;
        long r1 = 0, r2 = 0;
        int i = 0;
        for (i = 0; i < Math.min(n1, n2); i++) {
            r1 += num1[i] * carry;
            r2 += num2[i] * carry;
            carry *= Math.max(Math.max(num1[i], num2[i]) + 1, 2);
            r1 %= mod;
            r2 %= mod;
            carry %= mod;
        }

        for (; i < n1; i++) {
            r1 += num1[i] * carry;
            carry *= Math.max(num1[i] + 1, 2);
            r1 %= mod;
            carry %= mod;
        }
        for (; i < n2; i++) {
            r2 += num2[i] * carry;
            carry *= Math.max(num2[i] + 1, 2);
            r2 %= mod;
            carry %= mod;
        }

        while (r1 - r2 < 0) {
            r1 += mod;
        }

        System.out.println(r1 - r2);
    }
}
