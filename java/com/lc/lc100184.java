package lc;

import java.util.*;

/**
 * @author: 郭晨旭
 * @create: 2023-12-31 10:41
 * @version: 1.0
 */
public class lc100184 {
    public int maximumLength(String s) {
        Map<Character, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int cnt = 1;
            while (i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i)) {
                i++;
                cnt++;
            }
            temp = map.getOrDefault(s.charAt(i), new HashMap<>());
            temp.put(cnt, temp.getOrDefault(cnt, 0) + 1);
            map.put(s.charAt(i), temp);
        }

        int ans = -1;
        for (Map<Integer, Integer> value : map.values()) {
            for (Map.Entry<Integer, Integer> entry : value.entrySet()) {
                if (entry.getValue() >= 3) {
                    ans = Math.max(ans, entry.getKey());
                } else if ((value.get(entry.getKey() - 1) != null || entry.getValue() >= 2) && entry.getKey() >= 2) {
                    ans = Math.max(ans, entry.getKey() - 1);
                } else if (entry.getKey() >= 3) {
                    ans = Math.max(ans, entry.getKey() - 2);
                }
            }
        }

        return ans;
    }
}
