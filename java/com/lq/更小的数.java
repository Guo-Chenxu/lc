package lq;

import java.util.*;

public class 更小的数 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        int res = 0;
        boolean[][] dp = new boolean[str.length() + 1][str.length() + 1];
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    dp[i][j] = true;
                } else if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                res += dp[i][j] ? 1 : 0;
            }
        }
        System.out.println(res);
    }
}
