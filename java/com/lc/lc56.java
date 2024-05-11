package lc;

import java.util.*;
import java.util.Arrays;

public class lc56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int[] inter : intervals) {
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < inter[0]) {
                ans.add(new int[] { inter[0], inter[1] });
            } else {
                ans.get(ans.size() - 1)[0] = Math.min(ans.get(ans.size() - 1)[0], inter[0]);
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], inter[1]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
