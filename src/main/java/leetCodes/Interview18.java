package leetCodes;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class Interview18 {
    public ListNode deleteNode(ListNode head, int val) {
        //
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode newHead = root;
        while (root.next != null) {
            if (root.next.val == val) {
                root.next = root.next.next;
                break;
            }
            root = root.next;
        }
        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
