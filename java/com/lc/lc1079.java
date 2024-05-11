package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: exercise
 * @description: lc1079
 * @author: 郭晨旭
 * @create: 2023-05-19 22:01
 * @version: 1.0
 **/
public class lc1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>(map.keySet());
        return dfs(map, set, tiles.length());
    }

    public int dfs(Map<Character, Integer> map, Set<Character> set, int n) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        for (char c : set) {
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
                res += dfs(map, set, n - 1);
                map.put(c, map.get(c) + 1);
            }
        }
        return res;
    }
}
