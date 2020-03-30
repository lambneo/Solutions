package leetCodes;

/**
 * 寻找两个链表的是否相交，若相交找出交点
 */

public class Interview52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB==null||headA==null) return null;
        ListNode cur1=headA,cur2=headB;
        int n=0;
        while(cur1!=null){
            n++;
            cur1=cur1.next;
        }

        while(cur2!=null){
            n--;
            cur2=cur2.next;
        }
        cur1=n>0?headA:headB;
        cur2=cur1==headA?headB:headA;
        n=Math.abs(n);
        while(n>0){
            cur1=cur1.next;
            n--;
        }

        while(cur1!=cur2){
            cur2=cur2.next;
            cur1=cur1.next;
        }
        return cur1;
    }
}
