package lc;

import java.util.HashMap;
import java.util.Map;

public class lc17_05 {
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int sum = 0;
        int start = -1, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; ++i) {
            if (array[i].charAt(0) <= '9' && array[i].charAt(0) >= '0') {
                ++sum;
            } else {
                --sum;
            }
            if (map.containsKey(sum)) {
                int fi = map.get(sum);
                if (i - fi > maxLen) {
                    maxLen = i - fi;
                    start = fi + 1;
                }
            } else {
                map.put(sum, i);
            }
        }
        if (maxLen == 0) {
            return new String[] {};
        } else {
            String[] ans = new String[maxLen];
            System.arraycopy(array, start, ans, 0, maxLen);
            return ans;
        }
    }

    @Deprecated
    public String[] myFindLongestSubarray(String[] array) {
        int len = array.length;
        int cntL = 0, cntN = 0;
        int[] idx = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < len; ++i) {
            if (array[i].charAt(0) <= '9' && array[i].charAt(0) >= '0') {
                ++cntL;
            } else {
                ++cntN;
            }
            int val = cntL - cntN;
            map.putIfAbsent(val, i + 1);
            int j = map.getOrDefault(val, i + 1);
            if ((i + 1) - j > idx[1] - idx[0]) {
                idx[1] = i + 1;
                idx[0] = j;
            }
        }
        if (idx[1] - idx[0] == 0) {
            return new String[] {};
        } else {
            String[] ans = new String[idx[1] - idx[0]];
            int cnt = 0;
            for (int i = Math.max(0, idx[0]); i < idx[1]; ++i) {
                ans[cnt++] = array[i];
            }
            return ans;
        }
    }
}
