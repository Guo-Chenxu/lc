package lq;

import java.util.*;

public class 统计单词数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine().toLowerCase();
        String[] s = scanner.nextLine().toLowerCase().split(" ");
        int cnt = 0, fi = 0;
        for (int i = 0; i < s.length; i++) {
            if (p.equals(s[i])) {
                cnt++;
            }
            fi += cnt != 0 ? 0 : s[i].length() + 1;
        }
        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt + " " + fi);
        }
    }
}
