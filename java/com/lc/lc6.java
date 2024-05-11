package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-11-04 15:55
 * @version: 1.0
 */
public class lc6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = (numRows << 1) - 2, len = s.length();
        StringBuilder ans = new StringBuilder();

        for (int i = n, idx = 0; i >= 0 && idx < numRows; i -= 2, idx++) {
            int j = n - i, cnt = 0;
            for (int k = idx; k < len;) {
                ans.append(s.charAt(k));
                if (i == 0 || j == 0) {
                    k += i + j;
                    continue;
                }
                if ((cnt & 1) == 0) {
                    k += i;
                } else {
                    k += j;
                }
                cnt++;
            }
        }

        return ans.toString();
    }
}
