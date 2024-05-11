package lq;

import java.util.*;

public class 小鱼的游泳时间 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int a = Integer.parseInt(split[0]), b = Integer.parseInt(split[1]), c = Integer.parseInt(split[2]),
                d = Integer.parseInt(split[3]);
        int e = c * 60 + d - (a * 60 + b);
        System.out.println(e / 60 + " " + e % 60);
    }
}
