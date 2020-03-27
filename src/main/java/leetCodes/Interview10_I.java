package leetCodes;

/**
 * 斐波那契数列
 */
public class Interview10_I {
    public int fib(int n) {
        int a = 0, b = 1, res = 0;
        for (int i = 0; i < n; i++) {
            res = (a + b) % 1000000007;
            b = a;
            a = res;
        }
        return res;
    }
}
