package leetCodes;

import java.util.Stack;

/**
 * 逆向打印出链表
 */

public class Interview06 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            //这里可以直接将head.val push出来
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

}
