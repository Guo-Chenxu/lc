package lc;

import java.util.*;

/**
 * @program: exercise
 * @description: lc1625
 * @author: 郭晨旭
 * @create: 2023-03-19 11:15
 * @version: 1.0
 **/
public class lc1625 {
    public String findLexSmallestString(String s, int a, int b) {
        String ans = s;
        int len = s.length();
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        queue.add(ans);
        map.put(ans, 1);
        while (!queue.isEmpty()) {
            String string = queue.poll();
            if (ans.compareTo(string) > 0) {
                ans = string;
            }
            String con = (string + string).substring(len - b, len + len - b);
            if (!map.containsKey(con)) {
                map.put(con, 1);
                queue.add(con);
            }
            char[] chars = string.toCharArray();
            while (true) {
                for (int j = 1; j < len; j += 2) {
                    chars[j] = (char) ((chars[j] - '0' + a) % 10 + '0');
                }
                String temp = String.valueOf(chars);
                if (!map.containsKey(temp)) {
                    map.put(temp, 1);
                    queue.add(temp);
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
