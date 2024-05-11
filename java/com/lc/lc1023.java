package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: exercise
 * @description: lc1023
 * @author: 郭晨旭
 * @create: 2023-04-14 13:41
 * @version: 1.0
 **/
public class lc1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        pattern += "#";
        char[] patterns = pattern.toCharArray();
        for (String query : queries) {
            char[] chars = query.toCharArray();
            int idx = 0;
            boolean flag = true;
            for (char c : chars) {
                if (c == patterns[idx]) {
                    ++idx;
                } else if (c <= 'Z' && c >= 'A') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(patterns[idx] == '#');
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
