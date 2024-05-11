package lc;

import java.util.Arrays;

/**
 * @program: exercise
 * @description: lc6454
 * @author: 郭晨旭
 * @create: 2023-05-21 11:08
 * @version: 1.0
 **/
public class lc6454 {
    public String makeSmallestPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            char c = (char) Math.min(chars[l], chars[r]);
            chars[l] = c;
            chars[r] = c;
            ++l;
            --r;
        }
        return new String(chars);
    }
}
