package lc;

/**
 * @author: 郭晨旭
 * @create: 2024-01-06 12:28
 * @version: 1.0
 */
public class lc92 {

    public class ListNode {
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

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy, l = null, r = null;
            for (int i = 0; i <= right; i++) {
                if (i == left - 1) {
                    l = cur;
                } else if (i == right) {
                    r = cur;
                }
                cur = cur.next;
            }

            for (cur = l.next; l.next != r && cur.next != null;) {
                ListNode temp = cur.next.next;
                cur.next.next = l.next;
                l.next = cur.next;
                cur.next = temp;
            }
            return dummy.next;
        }
    }
}
