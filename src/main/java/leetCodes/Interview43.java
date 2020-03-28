package leetCodes;

/**
 * 求输入整型n中包含的数字1的个数
 *
 * f(n)为所求函数
 * 例子如n=1234，high=1, pow=1000, last=234
 * 可以将数字范围分成两部分1~999和1000~1234
 * 1~999这个范围1的个数是f(pow-1)
 * 1000~1234这个范围1的个数需要分为两部分：
 * 千分位是1的个数：千分位为1的个数刚好就是234+1(last+1)，注意，这儿只看千分位，不看其他位
 * 其他位是1的个数：即是234中出现1的个数，为f(last)
 * 所以全部加起来是f(pow-1) + last + 1 + f(last);
 *
 * 例子如3234，high=3, pow=1000, last=234
 * 可以将数字范围分成两部分1~999，1000~1999，2000~2999和3000~3234
 * 1~999这个范围1的个数是f(pow-1)
 * 1000~1999这个范围1的个数需要分为两部分：
 * 千分位是1的个数：千分位为1的个数刚好就是pow，注意，这儿只看千分位，不看其他位
 * 其他位是1的个数：即是999中出现1的个数，为f(pow-1)
 * 2000~2999这个范围1的个数是f(pow-1)
 * 3000~3234这个范围1的个数是f(last)
 * 所以全部加起来是pow + high*f(pow-1) + f(last);
 *
 */
public class Interview43 {
    public int countDigitOne(int n) {
        return func(n);
    }

    public int func(int n){
        if (n <= 1) return n;
        String s = String.valueOf(n);
        int height = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - height*pow;
        if (height == 1)
            return func(pow-1) + last + 1 + func(last);
        else
            return height*func(pow-1) + pow + func(last);
    }
}
