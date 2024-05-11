package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-11-04 14:56
 * @version: 1.0
 */
public class lc58 {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                ans++;
            } else if (s.charAt(i) == ' ' && ans > 0) {
                return ans;
            }
        }
        return ans;
    }
}
