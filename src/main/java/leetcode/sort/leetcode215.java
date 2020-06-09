package leetcode.sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最大的k个元素
 */
public class leetcode215 {
    //快速选择，时间O(n),空间O(1)
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length - 1, t = nums.length - k;
        while (r > l){
            int j = partition(nums, l, r);
            if (j == t) break;
            if (j > t)
                r = j - 1;
            else
                l = j + 1;
        }
        return nums[t];
    }

    private int partition(int[] nums, int l, int r){
        int i = l, j = r + 1, tmp = nums[l];
        while (i < j){
            while (i != r && nums[++i] < tmp);
            while (j != l && nums[--j] > tmp);
            if (i >= j) break;
            swap(nums, i ,j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i ,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    //建立小根堆，时间O(nlog(heapsize)),空间 k
    public int findKthLargest_Heap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int n : nums){
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
}
