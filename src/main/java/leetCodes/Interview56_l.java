package leetCodes;

/**
 * 数组中只有两个数字不重复，其余数字均出现两次，要求时间复杂度O(n),空间复杂度O(1)
 * 数字出现两次可联想到异或处理，利用n&(-n)找到异或结构二进制第一个不为0的位，对数
 * 组进行划分
 */
public class Interview56_l {
    public int[] singleNumbers(int[] nums) {
        int res = 0, NonZeroPoistion = 0, target1 = 0, target2 = 0;
        for (int i : nums) res ^= i;
        NonZeroPoistion = res&(-res);
        for (int i : nums){
            if ((i&NonZeroPoistion) != 0) target1 ^= i;
            else target2 ^= i;
        }
        return new int[]{target1, target2};
    }
}
