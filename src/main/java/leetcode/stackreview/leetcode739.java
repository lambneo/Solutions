package leetcode.stackreview;

import java.util.Stack;

public class leetcode739 {
    /**
     * 要求出数组中每个元素离比它大元素的距离，单调栈问题
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > stack.peek()) {
                int pre = stack.pop();
                ans[pre] = i - pre;
            }
            stack.push(i);
        }
        return ans;
    }
}
