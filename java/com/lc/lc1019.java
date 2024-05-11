package lc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: exercise
 * @description: lc1019
 * @author: 郭晨旭
 * @create: 2023-04-10 13:36
 * @version: 1.0
 **/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class lc1019 {
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int cnt = -1;
        while (head != null) {
            ++cnt;
            list.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < head.val) {
                list.set(stack.poll()[1], head.val);
            }
            stack.push(new int[] { cnt, head.val });
            head = head.next;
        }

        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
