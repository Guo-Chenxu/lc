package lc;

import java.util.Arrays;

/**
 * @program: exercise
 * @description: lc1376
 * @author: 郭晨旭
 * @create: 2023-05-01 10:45
 * @version: 1.0
 **/
public class lc1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] time = new int[n];
        Arrays.fill(time, -1);
        time[headID] = informTime[headID];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (time[i] == -1) {
                int nowTime = informTime[i];
                nowTime += dfs(manager, time, informTime, manager[i]);
                time[i] = nowTime;
            }
            res = Math.max(res, time[i]);
        }
        return res;
    }

    public int dfs(int[] manager, int[] time, int[] informTime, int idx) {
        if (manager[idx] == -1) {
            return informTime[idx];
        }
        if (time[idx] != -1) {
            return time[idx];
        }
        int nowTime = informTime[idx];
        nowTime += dfs(manager, time, informTime, manager[idx]);
        time[idx] = nowTime;
        return time[idx];
    }
}
