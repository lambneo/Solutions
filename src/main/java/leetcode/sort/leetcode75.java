package leetcode.sort;


public class leetcode75 {
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;
        int zero = -1, one =0, two = nums.length;
        while (one < two){
            if (nums[one] == 0)
                swap(nums, one++, ++zero);
            else if (nums[one] == 2)
                swap(nums, one, --two);
            else one++;
        }

        for (int j : nums){
            System.out.print(j + " ");
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        leetcode75 test = new leetcode75();
        test.sortColors(new int[]{1,0});
    }
}
