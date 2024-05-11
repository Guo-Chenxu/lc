package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-11-04 16:24
 * @version: 1.0
 */
public class lc28 {
    // todo kmp 学习
    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    public int[] getNext(String pat) {
        int len = pat.length(), k = -1;
        int[] next = new int[len];
        next[0] = k;
        for (int i = 1; i < len; i++) {
            while (k >= 0 && pat.charAt(i) != pat.charAt(k + 1)) {
                k = next[k];
            }
            if (pat.charAt(i) == pat.charAt(k + 1)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public int kmp(String str, String pat) {
        int[] next = getNext(pat);
        int n = str.length(), m = pat.length();
        for (int i = 0, j = -1; i < n; i++) {
            while (j >= 0 && str.charAt(i) != pat.charAt(j + 1)) {
                j = next[j];
            }
            if (str.charAt(i) == pat.charAt(j + 1)) {
                j++;
            }
            if (j == m - 1) {
                return i - j;
            }
        }
        return -1;
    }
}
