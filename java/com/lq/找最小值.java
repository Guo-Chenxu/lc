package lq;

import java.util.*;

public class 找最小值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] s = scanner.nextLine().split(" ");
        int ans = 0x7fffffff;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Integer.parseInt(s[i]));
        }
        System.out.println(ans);
    }
}
