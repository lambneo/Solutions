package leetCodes;


/**
 * 顺时针打印矩阵，考虑边界条件，清晰思考
 * 使用++i使代码简洁
 */
public class Interview29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];//左到右
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];//上到下
            if (--r < l) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];//右到左
            if (--b < t) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; //下到上
            if (++l > r) break;
        }
        return res;
    }


}
