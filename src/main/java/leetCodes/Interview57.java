package leetCodes;

public class Interview57 {
    public int[] twoSum(int[] nums, int target) {
        int beforeIndex = 0, afterIndex = nums.length - 1;
        while (beforeIndex < afterIndex){
            if (nums[beforeIndex] + nums[afterIndex] > target)
                afterIndex--;
            else if (nums[beforeIndex] + nums[afterIndex] < target)
                beforeIndex++;
            else return new int[]{nums[beforeIndex], nums[afterIndex]};
        }

        return new int[0];
    }
}
