package leetCodes;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 滑动窗口的最大值，借助大根堆或者借助单调双向队列
 */
public class Interview59_l {

    //大根堆构造解法
        public int[] maxSlidingWindow_LargeHeap(int[] nums, int k) {
            if (nums == null || nums.length < k || k < 1)
                return new int[0];

            //lambda简化
            Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);

            for (int i = 0; i < k; i++)
                queue.add(nums[i]);

            int[] ans = new int[nums.length - k + 1];
            ans[0] = queue.peek();
            for (int i = k; i < nums.length; i++){
                queue.remove(nums[i - k]);
                queue.add(nums[i]);
                ans[i - k + 1] = queue.peek();
            }

            return ans;
        }

    public int[] maxSlidingWindow_LinkedList(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k)
            return new int[0];


        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> qMax = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i])
                qMax.pollLast();
            //保存的是索引而不是值
            qMax.addLast(i);
            if (qMax.peekFirst() == i - k)
                qMax.pollFirst();

            if (i >= k - 1)
                res[index++] = nums[qMax.peekFirst()];

        }
        return res;
    }

}
