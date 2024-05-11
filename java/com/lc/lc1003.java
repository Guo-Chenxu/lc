package lc;

/**
 * @program: exercise
 * @description: lc1003
 * @author: 郭晨旭
 * @create: 2023-05-03 11:33
 * @version: 1.0
 **/
public class lc1003 {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
            if (sb.length() >= 3 && "abc".equals(sb.substring(sb.length() - 3))) {
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        return sb.isEmpty();
    }

    public boolean isValid01(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        for (char c : arr) {
            if (c > 'a' && (i == 0 || c - arr[--i] != 1)) {
                return false;
            }
            if (c < 'c') {
                arr[i++] = c;
            }
        }
        return i == 0;
    }
}
