package lc;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: 郭晨旭
 * @create: 2023-11-03 15:32
 * @version: 1.0
 */
public class lc42 {
    // public int trap(int[] height) {
    // int len = height.length;
    // int[] left = new int[len], right = new int[len + 1];
    //
    // left[0] = height[0];
    // for (int i = 1; i < len; i++) {
    // left[i] = Math.max(left[i - 1], height[i]);
    // }
    // right[len - 1] = height[len - 1];
    // for (int i = len - 2; i >= 0; i--) {
    // right[i] = Math.max(right[i + 1], height[i]);
    // }
    //
    // int ans = 0;
    // for (int i = 0; i < len; i++) {
    // ans += Math.min(left[i], right[i]) - height[i];
    // }
    //
    // return ans;
    // }

    public int trap(int[] height) {
        int[] l = new int[height.length], r = new int[height.length];

        l[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            l[i] = Math.max(l[i - 1], height[i]);
        }

        r[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(l[i], r[i]) - height[i];
        }
        return ans;
    }
}
