package lc;

/**
 * @program: exercise
 * @description: lc3
 * @author: 郭晨旭
 * @create: 2023-04-19 11:02
 * @version: 1.0
 **/
public class lc3 {
    // public int lengthOfLongestSubstring(String s) {
    // char[] chars = s.toCharArray();
    // int len = s.length();
    // int[] c = new int[128];
    // int l = 0, r = 0, temp = 0, res = 0;
    // while (r < len) {
    // while (r < len && c[chars[r]] == 0) {
    // ++c[chars[r]];
    // ++temp;
    // ++r;
    // }
    // res = Math.max(res, temp);
    // while (l < len && r < len && chars[l] != chars[r]) {
    // --c[chars[l]];
    // ++l;
    // --temp;
    // }
    // --c[chars[l]];
    // ++l;
    // --temp;
    // }
    // return res;
    // }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] cnt = new int[128];
        int l = 0, r = 0, ans = 0;
        while (l <= r && r < len) {
            if (cnt[chars[r]] == 0) {
                cnt[chars[r]] = ++r;
                ans = Math.max(ans, r - l);
            } else {
                int t = l;
                l = cnt[chars[r]];
                for (int i = t; i < cnt[chars[r]]; ++i) {
                    cnt[chars[i]] = 0;
                }
                cnt[chars[r]] = ++r;
            }
        }
        return ans;
    }
}
