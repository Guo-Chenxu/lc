package lc;

/**
 * @program: exercise
 * @description: lc2432
 * @author: 郭晨旭
 * @create: 2023-05-05 16:24
 * @version: 1.0
 **/
public class lc2432 {
    public int hardestWorker(int n, int[][] logs) {
        int len = logs.length;
        int res = logs[0][0], max = logs[0][1];
        for (int i = 1; i < len; ++i) {
            int now = logs[i][1] - logs[i - 1][1];
            if (now > max) {
                max = now;
                res = logs[i][0];
            } else if (now == max) {
                res = Math.min(res, logs[i][0]);
            }
        }
        return res;
    }
}
