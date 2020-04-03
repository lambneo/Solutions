package leetCodes;


/**
 * 排序数组寻找缺失数字，优先考虑二分查找
 */
public class Interview53_ll {
    public int missingNumber(int[] nums) {
       int i = 0, j = nums.length - 1;
       while (i <= j){
           int m = (i+j)/2;
           if (nums[m] == m) i = m+1;
           else j = m - 1;
       }
       return i;
    }
}
