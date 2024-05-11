package lc;

import java.util.HashMap;
import java.util.Map;

public class lc1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int len = names.length;
        String[] ans = new String[len];
        for (int i = 0; i < len; ++i) {
            int cnt = map.getOrDefault(names[i], 0);
            if (cnt == 0) {
                ans[i] = names[i];
                map.put(names[i], cnt + 1);
                continue;
            }
            while (map.containsKey(names[i] + "(" + cnt + ")")) {
                ++cnt;
            }
            map.put(names[i], cnt + 1);
            ans[i] = names[i] + "(" + cnt + ")";
        }
        return ans;
    }
}
