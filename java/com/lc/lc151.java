package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 郭晨旭
 * @create: 2023-11-04 15:05
 * @version: 1.0
 */
public class lc151 {
    public String reverseWords(String s) {
        int len = s.length();
        char[] chars = new char[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                chars[j++] = s.charAt(i);
            } else {
                if (i > 0 && s.charAt(i - 1) != ' ') {
                    chars[j++] = s.charAt(i);
                }
            }
        }
        if (chars[j - 1] == ' ') {
            j--;
        }

        reverse(chars, 0, j - 1);
        for (int l = 0, r = 0; l < j; r++) {
            if (r == j || chars[r] == ' ') {
                reverse(chars, l, r - 1);
                l = r + 1;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < j; i++) {
            ans.append(chars[i]);
        }

        return ans.toString();
    }

    public void reverse(char[] chars, int l, int r) {
        for (; l < r; l++, r--) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
        }
    }
}
