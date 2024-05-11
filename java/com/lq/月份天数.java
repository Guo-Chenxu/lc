package lq;

import java.util.*;

public class 月份天数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int year = Integer.parseInt(split[0]), month = Integer.parseInt(split[1]);
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(31);
                break;
            case 2:
                if (((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
                    System.out.println(29);
                } else {
                    System.out.println(28);
                }
                break;
            default:
                System.out.println(30);
                break;
        }
    }
}
