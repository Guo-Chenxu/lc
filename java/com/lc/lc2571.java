package lc;

/**
 * @author: 郭晨旭
 * @create: 2024-01-24 12:54
 * @version: 1.0
 */
public class lc2571 {
    public int minOperations(int n) {
        int ans = 0, cnt = 0;
        for (; n > 0; n >>= 1) {
            if ((n & 1) != 0) {
                cnt++;
            } else {
                if (cnt == 1) {
                    cnt = 0;
                    ans++;
                } else if (cnt > 1) {
                    cnt = 1;
                    ans++;
                }
            }
        }
        if (cnt == 1) {
            ans++;
        } else if (cnt > 1) {
            ans += 2;
        }
        return ans;
    }
}
