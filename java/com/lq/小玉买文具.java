package lq;

import java.util.*;

public class 小玉买文具 {
    public static void main(String[] args) {
        int price = 19;
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int x = Integer.parseInt(split[0]) * 10 + Integer.parseInt(split[1]);
        System.out.println(x / price);
    }
}
