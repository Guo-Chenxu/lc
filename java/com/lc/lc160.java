package lc;

/**
 * @author: 郭晨旭
 * @create: 2024-01-10 19:52
 * @version: 1.0
 */
public class lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 != null ? l1.next : headB;
            l2 = l2 != null ? l2.next : headA;
        }
        return l1;
    }
}
