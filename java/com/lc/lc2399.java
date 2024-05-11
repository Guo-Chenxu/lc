package lc;

/**
 * @program: exercise
 * @description: lc2399
 * @author: 郭晨旭
 * @create: 2023-04-09 11:57
 * @version: 1.0
 **/
public class lc2399 {
    public boolean checkDistances(String s, int[] distance) {
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[] vis = new boolean[26];
        for (int i = 0; i < len; ++i) {
            int next = i + distance[chars[i] - 'a'] + 1;
            System.out.println(next);
            if (!vis[chars[i] - 'a'] && (next >= len || chars[next] != chars[i])) {
                return false;
            }
            vis[chars[i] - 'a'] = true;
        }
        return true;
    }
}
