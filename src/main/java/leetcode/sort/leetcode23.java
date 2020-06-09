package leetcode.sort;


import java.util.PriorityQueue;

public class leetcode23 {
    //堆处理
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        if (lists.length == 0)
            return null;
        for (ListNode node : lists){
            if (node != null)
                heap.add(node);
        }
        while (!heap.isEmpty()){
            ListNode temp = heap.poll();
            cur.next = new ListNode(temp.val);
            cur = cur.next;
            if (temp.next != null)
                heap.add(temp.next);
        }

        return ans.next;
    }

    //不用递归的分治
    public ListNode mergeKLists_divide_conquer(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        while (len > 1){
            for (int i = 0; i < len/2; i++){
                lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1)/2;
        }

        return lists[0];
    }


    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (a != null && b != null){
            if (a.val >= b.val) {
                cur.next = b;
                b = b.next;
            }else {
                cur.next = a;
                a = a.next;
            }
            cur = cur.next;
        }
        cur.next = a == null? b : a;
        return res.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
