package leetcode.stackreview;

import java.util.Stack;

public class leetcode42 {
    /**
     * 接雨水，单调栈，本题是要找“沟”，而不是找比谁大的距离
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //这里其实是弹出本次采集雨水的下界索引
                int bottomindex = stack.pop();
                //为空说明采集完毕
                if (stack.isEmpty())
                    break;
                //真正要记录的是下界的前一个高度和目前高度
                int distance = i - stack.peek() - 1;
                int bound = Math.min(height[i], height[stack.peek()]) - height[bottomindex];
                ans += bound * distance;
            }
            stack.push(i);
        }
        return ans;
    }
}
