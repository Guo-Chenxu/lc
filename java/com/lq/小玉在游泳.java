package lq;

import java.util.*;

public class 小玉在游泳 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double s = Double.parseDouble(scanner.nextLine());
        double ss = 2.0, cur = 0;
        int cnt = 0;
        while (cur < s) {
            cur += ss;
            ss *= 0.98;
            cnt++;
        }
        System.out.println(cnt);
    }
}
