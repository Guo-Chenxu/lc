package lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: exercise
 * @description: lc1048
 * @author: 郭晨旭
 * @create: 2023-04-27 09:33
 * @version: 1.0
 **/
public class lc1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;
        int res = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            int len = sb.length();
            int cnt = 1;
            for (int i = 0; i < len; ++i) {
                if (map.containsKey(sb.replace(i, i + 1, "").toString())) {
                    cnt = Math.max(cnt, map.get(sb.toString()) + 1);
                }
                sb = new StringBuilder(word);
            }
            map.put(sb.toString(), cnt);
            res = Math.max(res, cnt);
        }
        return res;
    }
}
