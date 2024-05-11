package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-11-13 21:41
 * @version: 1.0
 */
public class lc125 {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (toLittle(s.charAt(l)) != toLittle(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public char toLittle(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        }
        return (char) (c - 'A' + 'a');
    }
}
