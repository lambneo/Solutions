package leetCodes;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * 可以从右上角或者左下角开始,左下角开始的话，当前元素若比角落元素小则上移，大则右移动
 */
public class Interview04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, col = matrix[0].length;
        int r = rows - 1, c = 0;
        while (c <= col - 1 && r >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                c++;
            else
                r--;
        }
        return false;
    }
}
