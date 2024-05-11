package lq;

import java.util.*;

public class 修剪灌木 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int i = 0; i < n; i++) {
            int res = Math.max((n - i - 1) * 2, 2 * i);
            System.out.println(res);
        }
    }
}
