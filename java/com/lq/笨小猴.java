package lq;

import java.util.*;

public class 笨小猴 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        char[] cnt = new char[26];
        int max = -1, min = 0x7fffffff;
        for (Character c : nextLine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i : cnt) {
            if (i > 0 && i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }
        int x = max - min;
        if (x == 0 || x == 1) {
            System.out.println("No Answer\n0");
            return;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                System.out.println("No Answer\n0");
                return;
            }
        }
        System.out.println("Lucky Word");
        System.out.println(x);
    }
}
