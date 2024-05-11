package lc;

public class lc1653 {
    public int minimumDeletions(String s) {
        int len = s.length();
        int[] cnta = new int[len + 1];
        int[] cntb = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            cnta[i + 1] = cnta[i] + (s.charAt(i) == 'a' ? 1 : 0);
            cntb[i + 1] = cntb[i] + (s.charAt(i) == 'b' ? 1 : 0);
        }
        int res = len;
        for (int i = 1; i <= len; ++i) {
            res = Math.min(res, cntb[i] + cnta[len] - cnta[i]);
        }
        return res;
    }
}
