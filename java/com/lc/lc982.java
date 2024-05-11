package lc;

public class lc982 {
    public int countTriplets(int[] nums) {
        int[] cnt = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                ++cnt[x & y];
            }
        }
        int res = 0;
        for (int x : nums) {
            for (int i = 0; i < (1 << 16); ++i) {
                if ((x & i) == 0) {
                    res += cnt[i];
                }
            }
        }
        return res;
    }
}
