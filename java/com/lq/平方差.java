package lq;

import java.util.*;

public class 平方差 {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(" ");
        int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if ((i & 1) == 1 || (i & 3) == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
