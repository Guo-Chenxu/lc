package lq;

import java.util.*;

public class 金币 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int ans = 0, cnt = 1;
        for (int i = 1; i <= n;) {
            int t = cnt;
            while (t > 0 && i <= n) {
                ans += cnt;
                t--;
                i++;
            }
            cnt++;
        }
        System.out.println(ans);
    }
}
