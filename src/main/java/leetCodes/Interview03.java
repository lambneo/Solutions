package leetCodes;

import java.util.HashSet;
import java.util.Set;

public class Interview03 {

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * @param nums
     * @return ans
     */
    public int findRepeatNumber(int[] nums) {
        //使用HashSet,空间复杂度O(n),时间复杂度O(n)
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i))
                return i;
            else
                set.add(i);
        }

        return 0;

    }

    /**
     * 遍历数组，如果当前元素不等于对应下标值，则循环把这个元素和他对应下标的位置上
     * 的元素交换，直到当前元素等于对应下标值，找到的条件是，如果这个元素本来应该在
     * 的位置上已经有了一个相等的数字
     * 时间复杂度O(n) 空间复杂度O(1)
     */

    public int findRepeatNumberBestSoloution(int[] nums) {
        if (nums.length == 0)
            return Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                swap(nums, i, nums[i]);
            }
        }

        return 0;

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}