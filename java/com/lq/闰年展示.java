package lq;

import java.util.*;

public class 闰年展示 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int start = Integer.parseInt(split[0]), end = Integer.parseInt(split[1]);
        List<Integer> res = new ArrayList<>();
        for (int year = start; year <= end; year++) {
            if (((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
                res.add(year);
            }
        }
        System.out.println(res.size());
        for (int y : res) {
            System.out.print(y + " ");
        }
    }
}
