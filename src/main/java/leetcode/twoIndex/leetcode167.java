package leetcode.twoIndex;

/**
 * 已排序数组，求两数之和等于目标值，双指针
 */
public class leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) return null;
        int index1 = 0, index2 = numbers.length - 1;
        while (index1 < index2){
            if (numbers[index1] + numbers[index2] < target)
                index1++;
            if (numbers[index1] + numbers[index2] == target)
                return new int[]{index1 + 1, index2 + 1};
            if (numbers[index1] + numbers[index2] > target)
                index2--;
        }
        return null;
    }
}
