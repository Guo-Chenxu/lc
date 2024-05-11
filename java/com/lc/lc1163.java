package lc;

/**
 * @program: exercise
 * @description: lc1163
 * @author: 郭晨旭
 * @create: 2023-04-24 13:40
 * @version: 1.0
 **/
public class lc1163 {
    public String lastSubstring(String s) {
        int len = s.length();
        int i = 0, j = 1;
        char[] chars = s.toCharArray();
        while (j < len) {
            int k = 0;
            while (j + k < len && chars[i + k] == chars[j + k]) {
                ++k;
            }
            if (j + k < len && chars[i + k] < chars[j + k]) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }
}
