package lc;

/**
 * @program: exercise
 * @description: lc1053
 * @author: 郭晨旭
 * @create: 2023-04-03 13:10
 * @version: 1.0
 **/
public class lc1053 {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        for (int i = len - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                int m = binarySearch(arr, i + 1, len - 1, arr[i]);
                while (m > i + 1) {
                    if (arr[m - 1] == arr[m]) {
                        --m;
                    }
                }
                int temp = arr[m];
                arr[m] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        return arr;
    }

    public int binarySearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
