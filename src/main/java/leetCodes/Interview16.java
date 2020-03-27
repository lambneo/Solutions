package leetCodes;

/**
 * 利用二进制特点简化运算
 * 快速幂，思路与interview15类似
 */
public class Interview16 {


    public double myPow(double x, int n) {
        double res = 0.0;
        long b = n;
        if (b == 0)
            return 1;
        if (b == 1)
            return x;
        if (x == 0.0)
            return 0;
        if (b > 0) {
            res = myPowNormal(x, b);
        }
        if (b < 0) {
            b = -b;
            res = myPowNormal(1.0 / x, b);
        }
        return res;
    }

    public double myPowNormal(double x, long b) {
        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1)
                res *= x;
            x *= x;
            b >>= 1;

        }
        return res;
    }
}
