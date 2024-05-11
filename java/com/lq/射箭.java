package lq;

import java.util.*;

public class 射箭 {
    public static void main(String[] args) {
        String[] split = new Scanner(System.in).nextLine().split(" ");
        int a = Integer.parseInt(split[0]), b = Integer.parseInt(split[1]), c = Integer.parseInt(split[2]);
        int cnt = 0;
        if (a + b > c) {
            cnt++;
        } else if (a + c > b) {
            cnt++;
        } else if (b + c > a) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
