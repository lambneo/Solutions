package leetCodes;

/**
 * 求连续子数组的最大和
 */

public class Interview42 {
    public int maxSubArray(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++){
            nums[i] += Math.max(0, nums[i-1]);
            res = Math.max(res, nums[i]);
        }

        return res;
    }
}
