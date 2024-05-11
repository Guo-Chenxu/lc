package lq;

import java.util.*;

public class 冶炼金属 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int min = -1, max = 0x7fffffff;
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            max = Math.min(max, (int) Math.floor(a * 1.0 / b));
            min = Math.max(min, (int) Math.ceil(a * 1.0 / (b + 1)));
        }
        System.out.println(min + " " + max);
    }
}