package lc;

import java.util.ArrayDeque;

/**
 * @author: 郭晨旭
 * @create: 2024-01-24 16:04
 * @version: 1.0
 */
public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }
            deq.addLast(i);
            while (deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deq.peek()];
            }
        }
        return ans;
    }
}
