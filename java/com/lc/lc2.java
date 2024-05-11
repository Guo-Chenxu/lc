package lc;

public class lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, now;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
            now = l1.val + l2.val + carry;
            carry = now / 10;
            cur.next = new ListNode(now % 10, null);
            cur = cur.next;
        }
        for (; l1 != null; l1 = l1.next) {
            now = l1.val + carry;
            carry = now / 10;
            cur.next = new ListNode(now % 10, null);
            cur = cur.next;
        }
        for (; l2 != null; l2 = l2.next) {
            now = l2.val + carry;
            carry = now / 10;
            cur.next = new ListNode(now % 10, null);
            cur = cur.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry, null);
        }
        return dummy.next;
    }
}
