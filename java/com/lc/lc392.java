package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-11-19 17:31
 * @version: 1.0
 */
public class lc392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
