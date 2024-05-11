package lc;

public class lc21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = new ListNode(list1.val, null);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val, null);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return dummy.next;
    }
}
