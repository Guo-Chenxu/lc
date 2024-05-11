package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: exercise
 * @description: lc6340
 * @author: 郭晨旭
 * @create: 2023-05-14 10:32
 * @version: 1.0
 **/
public class lc6340 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        int idx = 1;
        visited[idx] = true;
        for (int i = 1;; ++i) {
            idx = (i * k + idx) % n;
            idx = idx == 0 ? n : idx;
            if (visited[idx]) {
                break;
            }
            visited[idx] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                list.add(i);
            }
        }
        int len = list.size();
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
