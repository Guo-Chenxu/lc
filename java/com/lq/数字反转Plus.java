package lq;

import java.util.*;

public class 数字反转Plus {
    public static void main(String[] args) {
        String in = new Scanner(System.in).nextLine();
        if (in.contains("/")) {
            String[] split = in.split("/");
            System.out.println(reverse(split[0], 0) + '/' + reverse(split[1], 0));
        } else if (in.contains("%")) {
            System.out.println(reverse(in.substring(0, in.length() - 1), 0) + '%');
        } else if (in.contains(".")) {
            String[] split = in.split("\\.");
            System.out.println(reverse(split[0], 0) + '.' + reverse(split[1], 1));
        } else {
            System.out.println(reverse(in, 0));
        }
    }

    public static String reverse(String in, int flag) {
        char[] charArray = in.toCharArray();
        for (int l = 0, r = charArray.length - 1; l <= r; l++, r--) {
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
        }
        if (charArray.length == 1) {
            return String.valueOf(charArray);
        }
        if (flag == 0) {
            int i = 0;
            while (i < charArray.length && charArray[i] == '0') {
                i++;
            }
            if (i == charArray.length) {
                return "0";
            }
            return String.valueOf(charArray, i, charArray.length - i);
        } else {
            int i = charArray.length - 1;
            while (i >= 0 && charArray[i] == '0') {
                i--;
            }
            if (i < 0) {
                return "0";
            }
            return String.valueOf(charArray, 0, i + 1);
        }
    }
}
