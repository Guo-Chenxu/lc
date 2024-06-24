package lc;

import java.util.*;

public class lc503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            ans[i] = -1;
        }

        for (int cnt = 0; cnt < 2; cnt++){
            for (int i = 0; i < nums.length; i++){
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                    ans[stack.poll()] = nums[i];
                }
                stack.push(i);
            }
        }

        return ans;
    }
}