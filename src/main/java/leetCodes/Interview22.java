package leetCodes;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 */
public class Interview22 {

    //将链表元素放入栈中,内存超限制，改用双指针
    public ListNode getKthFromEnd_OutMemery(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head.next != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.size() < k)
            return null;
        ListNode newHead = stack.pop();
        for (int i = 0; i < k - 1; i++) {
            newHead.next = stack.pop();
        }
        return newHead;

    }

    //双指针,快慢指针，即第二个指针永远比第一个指针慢k步
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            if (former == null) return null;
            former = former.next;
        }

        //注意边界条件
        while (former != null) {
            latter = latter.next;
            former = former.next;
        }
        return latter;

    }


}

