package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-11-03 15:28
 * @version: 1.0
 */
public class lc135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] l = new int[len];
        int[] r = new int[len];

        l[0] = 1;
        for (int i = 1; i < len; i++) {
            l[i] = ratings[i] > ratings[i - 1] ? l[i - 1] + 1 : 1;
        }
        r[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            r[i] = ratings[i] > ratings[i + 1] ? r[i + 1] + 1 : 1;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += (Math.max(l[i], r[i]));
        }

        return ans;
    }
}
