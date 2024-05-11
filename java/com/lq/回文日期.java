package lq;

import java.util.*;

public class 回文日期 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String d1 = scanner.nextLine();
        String d2 = scanner.nextLine();
        int dd1 = Integer.parseInt(d1), dd2 = Integer.parseInt(d2);
        int y1 = Integer.parseInt(d1.substring(0, 4)), y2 = Integer.parseInt(d2.substring(0, 4));
        int res = 0;
        for (int i = y1; i <= y2; i++) {
            int temp = reverse(i);
            if (temp >= dd1 && temp <= dd2 && check(String.valueOf(temp))) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        for (int i = sb.length() - 1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }

    public static boolean check(String date) {
        int year = Integer.parseInt(date.substring(0, 4)),
                month = Integer.parseInt(date.substring(4, 6)),
                day = Integer.parseInt(date.substring(6, 8));
        // System.out.println(year + " " + month + " " + day);
        if (month < 1 || month > 12) {
            return false;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return day >= 1 && day <= 31;
            case 2:
                if (((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
                    return day >= 1 && day <= 29;
                } else {
                    return day >= 1 && day <= 28;
                }
            default:
                return day >= 1 && day <= 30;
        }
    }
}
