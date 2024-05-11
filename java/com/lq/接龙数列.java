package lq;

import java.util.*;

public class 接龙数列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] str = scanner.nextLine().split(" ");

        int[] dp = new int[10];
        int ans = 0;
        for (String s : str) {
            int a = s.charAt(0) - '0', b = s.charAt(s.length() - 1) - '0';
            dp[b] = Math.max(dp[b], dp[a] + 1);
            ans = Math.max(ans, dp[b]);
        }
        System.out.println(n - ans);
    }
}
