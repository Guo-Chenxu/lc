package lc;

/**
 * @program: exercise
 * @description: lc2404
 * @author: 郭晨旭
 * @create: 2023-04-13 14:18
 * @version: 1.0
 **/
public class lc2404 {
    public int mostFrequentEven(int[] nums) {
        int[] ans = new int[50001];
        int len = nums.length;
        int max = 0, res = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                int x = (num >> 1);
                ++ans[x];
                if (ans[x] > max) {
                    max = ans[x];
                    res = num;
                } else if (ans[x] == max && num < res) {

                    res = num;

                }
            }
        }
        return max == 0 ? -1 : res;
    }
}
