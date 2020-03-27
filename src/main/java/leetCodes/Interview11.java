package leetCodes;


/**
 * 一般情况下二分查找即可
 * 但需要考虑二分点均等于两边指针指向值相等的情况，此时只能顺序查找
 * 需要考虑数组旋转的个数为0的情况
 */
public class Interview11 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
