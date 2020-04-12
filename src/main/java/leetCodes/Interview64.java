package leetCodes;

/**
 * 利用&&短路特性编写递归
 */
public class Interview64 {
    public int sumNums(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sumNums(n - 1)) == 0);
        return sum;
    }
}
