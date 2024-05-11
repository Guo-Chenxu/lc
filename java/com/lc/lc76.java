package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: 郭晨旭
 * @create: 2024-01-24 16:49
 * @version: 1.0
 */
public class lc76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        String ans = "";
        while (l <= r && r < s.length()) {
            while (r < s.length() && !check(map)) {
                if (map.containsKey(s.charAt(r))) {
                    map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);
                }
                r++;
            }
            while (check(map)) {
                if (l <= r && (!map.containsKey(s.charAt(l)) || map.getOrDefault(s.charAt(l), 0) < 0)) {
                    if (map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                    }
                    l++;
                } else {
                    break;
                }
            }
            if (check(map)) {
                if (ans.isEmpty() || ans.length() > r - l) {
                    ans = s.substring(l, r);
                }
            }
            while (l <= r && check(map)) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                l++;
            }
        }
        return ans;
    }

    public boolean check(Map<Character, Integer> map) {
        for (Character c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }
        return true;
    }
}
