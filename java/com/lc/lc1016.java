package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: exercise
 * @description: lc1016
 * @author: 郭晨旭
 * @create: 2023-05-11 10:50
 * @version: 1.0
 **/
public class lc1016 {
    public boolean queryString(String s, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] bits = s.toCharArray();
        int len = s.length();
        // int num = 0;
        for (int i = 0; i < len; ++i) {
            while (bits[i] == '0') {
                ++i;
            }
            int num = 0;
            for (int j = i; j < len; ++j) {
                num = num * 2 + bits[j] - '0';
                if (num >= 1 && num <= n) {
                    map.put(num, j);
                } else {
                    // num = num - (int) ((bits[i] - '0') * Math.pow(2, j - i - 1));
                    break;
                }
            }
            // num = 0;
        }
        return map.size() == n;
    }

    public boolean queryString01(String s, int n) {
        for (int i = 1; i <= n; ++i) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
