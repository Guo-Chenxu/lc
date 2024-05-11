package lc;

/**
 * @program: exercise
 * @description: lc6361
 * @author: 郭晨旭
 * @create: 2023-04-09 10:56
 * @version: 1.0
 **/
public class lc6361 {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (isPrime(nums[i][i])) {
                ans = Math.max(ans, nums[i][i]);
            }
            if (isPrime(nums[i][n - i])) {
                ans = Math.max(ans, nums[i][n - i]);
            }
        }
        return ans;
    }

    public static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        // 只有6x-1和6x+1的数才有可能是质数
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        // 判断这些数能否被小于sqrt(n)的奇数整除
        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;

    }
}