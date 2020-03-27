package Sort;


public class HeapSort{
    /**
     * 数组第 0 个位置不能有元素
     */

    public void sort(int[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--)
            sink(nums, k, N);

        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    private void sink(int[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && nums[j] < nums[j + 1])
                j++;
            if (nums[k] >= nums[j])
                break;
            swap(nums, k, j);
            k = j;
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
