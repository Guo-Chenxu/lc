package lc;

import java.util.*;

/**
 * @author: 郭晨旭
 * @create: 2024-01-09 19:18
 * @version: 1.0
 */
public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = hash(str);
            List<String> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(str);
            map.put(hash, list);
        }
        return new ArrayList<>(map.values());
    }

    public String hash(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
