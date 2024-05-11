package lq;

import java.util.*;

public class 幸运数 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 10; i <= 100000000; i++) {
            String s = String.valueOf(i);
            if ((s.length() & 1) == 0) {
                int x = s.length() >> 1;
                int l = 0, r = 0;
                for (int j = 0; j < x; j++) {
                    l += s.charAt(j);
                }
                for (int j = x; j < s.length(); j++) {
                    r += s.charAt(j);
                }
                if (l == r) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
