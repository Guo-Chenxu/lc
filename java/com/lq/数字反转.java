package lq;

import java.util.*;

public class 数字反转 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();
        for (int l = 0, r = charArray.length - 1; l <= r; l++, r--) {
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
        }
        System.out.println(charArray);
    }
}
