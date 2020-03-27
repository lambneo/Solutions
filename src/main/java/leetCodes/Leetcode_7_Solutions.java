package leetCodes;

public class Leetcode_7_Solutions {

    /**
     * @author ziyuy
     * 将整数数字位置颠倒，注意需要整数是否会溢出，这也是这道题目的设计思想
     * 算法复杂度为O(logx)
     */
    public static int reverse1(int x) {
        int temp = x;
        int count = 0;
        int ans = 0;
        if (Math.abs(x) > Math.pow(2, 31)) {
            return 0;
        } else {
            while (temp != 0) {
                temp = temp / 10;
                count++;
            }
            temp = x;
            for (int i = 0; i < count; i++) {
                int t = temp % 10;
                temp = temp / 10;
                int index = (int) (t * Math.pow(10, count - i - 1));
                if ((count - i == 10 && Math.abs(t) > 2) || Math.abs(Integer.MAX_VALUE) - Math.abs(ans) <= Math.abs(index)) {
                    return 0;
                }

                ans = ans + index;


            }
        }
        return ans;

    }

    /**
     * 此为官方题解，复杂度为O(logx)
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int in = 2561;
        System.out.println(reverse(in));

    }

}
