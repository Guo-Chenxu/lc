package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-12-31 10:38
 * @version: 1.0
 */
public class lc100166 {
    public boolean hasTrailingZeros(int[] nums) {
        int cnt = 0;
        for (int i : nums) {
            if ((i & 1) == 0) {
                cnt++;
            }
        }
        return cnt >= 2;
    }
}
