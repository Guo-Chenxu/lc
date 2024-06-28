package lc;

import java.util.*;

public class lc207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] cnts = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        for (int[] p : prerequisites) {
            List<Integer> temp = map.getOrDefault(p[1], new ArrayList<>());
            temp.add(p[0]);
            map.put(p[1], temp);
            cnts[p[0]]++;
        }

        Deque<Integer> list = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (cnts[i] == 0) {
                list.add(i);
                res++;
            }
        }
        while (!list.isEmpty()) {
            int now = list.poll();
            List<Integer> next = map.getOrDefault(now, new ArrayList<>());
            for (int n : next) {
                cnts[n]--;
                if (cnts[n] == 0) {
                    list.add(n);
                    res++;
                }
            }
        }

        return res == numCourses;
    }
}
