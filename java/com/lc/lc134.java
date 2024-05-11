package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-11-03 15:28
 * @version: 1.0
 */
public class lc134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0, sum = 0, tot = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            tot += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                ans = i + 1;
            }
        }

        return tot < 0 ? -1 : ans;
    }
}
