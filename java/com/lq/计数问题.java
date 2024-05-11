package lq;

import java.util.*;

public class 计数问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]), x = Integer.parseInt(split[1]);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int t = i;
            while (t != 0) {
                if (t % 10 == x) {
                    ans++;
                }
                t /= 10;
            }
        }
        System.out.println(ans);
    }
}
