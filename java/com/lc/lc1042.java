package lc;

import java.util.*;

/**
 * @program: exercise
 * @description: lc1042
 * @author: 郭晨旭
 * @create: 2023-04-15 10:35
 * @version: 1.0
 **/
public class lc1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] path : paths) {
            List<Integer> l = map.getOrDefault(path[0], new ArrayList<>());
            l.add(path[1]);
            map.put(path[0], l);
            List<Integer> l1 = map.getOrDefault(path[1], new ArrayList<>());
            l1.add(path[0]);
            map.put(path[1], l1);
        }
        for (int i = 1; i <= n; ++i) {
            boolean[] vis = new boolean[4];
            for (Integer x : map.get(i)) {
                if (ans[x] != 0) {
                    vis[ans[x] - 1] = true;
                }
            }
            for (int j = 0; j < 4; ++j) {
                if (!vis[j]) {
                    ans[i] = j + 1;
                }
            }
        }
        return ans;
    }
}
