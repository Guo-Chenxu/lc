package lq;

import java.util.*;

public class 闰年判断 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        int year = Integer.parseInt(nextLine);
        System.out.println(((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ? 1 : 0);
    }
}
