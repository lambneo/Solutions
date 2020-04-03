package leetCodes;

/**
 * 排序数组问题，优先考虑二分查找
 */
public class Interview53_l {
    public int search(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] <= target) i = m + 1;
                else j = m - 1;
            }
            int right = i;

            i = 0; j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] < target) i = m + 1;
                else j = m - 1;
            }
            int left = j;

            return right - left - 1;
        }

    public static void main(String[] args) {
        Interview53_l solo = new Interview53_l();
        System.out.print(solo.search(new int[]{1}, 1));

    }
}
