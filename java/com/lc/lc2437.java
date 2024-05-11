package lc;

/**
 * @program: exercise
 * @description: lc2437
 * @author: 郭晨旭
 * @create: 2023-05-09 11:36
 * @version: 1.0
 **/
public class lc2437 {
    public int countTime(String time) {
        return f(time.substring(0, 2), 24) * f(time.substring(3), 60);
    }

    private int f(String s, int m) {
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            boolean a = s.charAt(0) == '?' || s.charAt(0) - '0' == i / 10;
            boolean b = s.charAt(1) == '?' || s.charAt(1) - '0' == i % 10;
            cnt += a && b ? 1 : 0;
        }
        return cnt;
    }
}
