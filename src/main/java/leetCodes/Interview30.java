package leetCodes;


import java.util.Stack;

/**
 * 包含min函数的最小栈，要求所有操作时间复杂度为O(1)
 * top, push, pop操作本来就是O(1)，难点在于min函数
 * 使用辅助栈来完成，辅助栈帮助完成
 */
public class Interview30 {

    class MinStack {
        private Stack<Integer> A, B;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.add(x);
            if (B.empty() || B.peek() >= x)
                B.add(x);
        }

        public void pop() {
            if (B.peek().equals(A.pop()))//A也要出栈
                B.pop();

        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.pop();
        }
    }
}
