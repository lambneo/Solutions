package leetcode.twoIndex;


public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode index1 = head, index2 = head.next;
        while (index1 != null && index2 != null && index2.next != null){
            if (index1 == index2) return true;
            index1 = index1.next;
            index2 = index2.next.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
