package lc;

public class lc2379 {
    public int minimumRecolors(String blocks, int k) {
        int res = 0;
        for (int i = 0; i < k; ++i) {
            if (blocks.charAt(i) == 'W') {
                ++res;
            }
        }
        int ans = res;
        for (int l = 0, r = k; l < blocks.length() && r < blocks.length(); ++l, ++r) {
            if (blocks.charAt(l) == 'W') {
                --res;
            }
            if (blocks.charAt(r) == 'W') {
                ++res;
            }
            ans = Math.min(ans, res);
        }
        return ans;
    }
}
