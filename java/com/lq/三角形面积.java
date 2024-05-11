package lq;

import java.util.*;

public class 三角形面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        double a = Double.parseDouble(split[0]), b = Double.parseDouble(split[1]), c = Double.parseDouble(split[2]);
        double p = (a + b + c) / 2;
        double ans = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.printf("%.1f", ans);
    }
}
