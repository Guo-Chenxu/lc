package lc;

import java.util.*;

public class lc424 {
    // public int characterReplacement(String s, int k) {
    // int[] cnt = new int[26];
    // int sum = 0, curMax = 0, res = 0;
    // int i = 0, j = 0;
    // while (i <= j && j < s.length()) {
    // cnt[s.charAt(j) - 'A']++;
    // sum++;
    // curMax = Arrays.stream(cnt).max().orElse(0);
    // while (i <= j && sum - curMax > k) {
    // cnt[s.charAt(i) - 'A']--;
    // curMax = Arrays.stream(cnt).max().orElse(0);
    // sum--;
    // i++;
    // }
    // res = Math.max(res, j - i + 1);
    // j++;
    // }
    // return res;
    // }

    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int curMax = 0, res = 0;
        int i = 0, j = 0;
        while (i <= j && j < s.length()) {
            cnt[s.charAt(j) - 'A']++;
            curMax = Math.max(curMax, cnt[s.charAt(j) - 'A']);
            j++;
            while (j - i > curMax + k) {
                // 内层循环 curMax 不用维护
                // 每次 i 增加后如果下一次读到相同字符则 curMax 不变
                // 如果读到新的字符, 若想要res增加, 则 j - i 一定增加, curMax 一定要比之前大才行
                cnt[s.charAt(i) - 'A']--;
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        new lc424().characterReplacement("ABAB", 2);
    }
}
