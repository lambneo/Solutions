package leetCodes;


import java.util.Stack;

/**
 * 判断pop序列对于push是否正确
 * 即边push边判断pop的选项
 */
public class Interview31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushed[pushIndex]);
            while (popIndex < n && !stack.empty() && stack.peek() == popped[popIndex]) {//注意是while哦
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
