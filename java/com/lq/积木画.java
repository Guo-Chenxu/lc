package lq;

import java.util.*;

public class 积木画 {

    static long mod = 1000000007;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n <= 2) {
            switch (n) {
                case 0:
                case 1:
                    System.out.println("1");
                    break;
                default:
                    System.out.println("2");
                    break;
            }
            return;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % mod;
        }
        System.out.println(dp[n]);
    }
}
