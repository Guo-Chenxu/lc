package lc;

/**
 * @program: exercise
 * @description: lc1574
 * @author: 郭晨旭
 * @create: 2023-03-25 12:12
 * @version: 1.0
 **/
public class lc1574 {

    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length, right = len - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            --right;
        }
        if (right == 0) {
            return 0;
        }
        int ans = right;
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; ++left) {
            while (right < len && arr[right] < arr[left]) {
                ++right;
            }
            ans = Math.min(ans, right - left - 1);
        }
        return ans;
    }

    public int myFindLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int lAns = 1, rAns = 1;
        for (int i = len - 2; i >= 0; --i) {
            if (arr[i] <= arr[i + 1]) {
                ++rAns;
            } else {
                break;
            }
        }
        for (int i = 1; i < len; ++i) {
            if (arr[i] >= arr[i - 1]) {
                ++lAns;
            } else {
                break;
            }
        }
        if (rAns == len) {
            return 0;
        }
        int ans = Math.max(lAns, rAns);
        for (int i = len - rAns; i < len; ++i) {
            int x = search(arr, 0, lAns - 1, arr[i]);
            ans = Math.max(ans, x + 1 + len - i);
        }
        return len - ans;
    }

    public int search(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int m = ((l + r) >> 1);
            if (arr[m] == target) {
                for (int i = m + 1; i <= r; ++i) {
                    if (arr[i] == target) {
                        ++m;
                    }
                }
                return m;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
