package leetCodes;

/**
 * 合并两个增序链表，合并后不递减
 */
public class Interview25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null)
            return l1;

        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //考虑一个链表为空后的结果，剩余的链表一定是大于当前cur所有元素的
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}
