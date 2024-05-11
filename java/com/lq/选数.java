package lq;

import java.util.*;
import java.math.*;

public class 选数 {

    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        String[] split = scanner.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        dfs(nums, 0, k, 0, 0);
        System.out.println(res);
    }

    public static void dfs(int[] nums, int cur, int k, int step, int tot) {
        if (step == k) {
            if (isPrime(tot)) {
                res++;
            }
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            dfs(nums, i + 1, k, step + 1, tot + nums[i]);
        }
    }

    public static boolean isPrime(int tot) {
        if (tot < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(tot); i++) {
            if (tot % i == 0) {
                return false;
            }
        }
        return true;
    }
}
