package lc;

import java.util.*;

public class lc234 {
    public boolean isPalindrome(ListNode head) {
        // 双指针找到中间位置, 慢指针遍历的同时反转前半部分链表, 然后从中间向两边比较
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy, pre = dummy, temp;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if (fast.next == null) {
            fast = slow.next;
            slow.next = pre;
        } else if (fast.next.next == null) {
            fast = slow.next.next;
            slow.next = pre;
        }
        while (fast != null && slow.val != -1) {
            if (fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
