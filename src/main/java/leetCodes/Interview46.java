package leetCodes;

/**
 * 数字翻译成字符串的最大组数,dp中等
 */
public class Interview46 {
    //时间O(n)，空间O(n)
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1, tmp = 0;
        for (int i = 1; i < s.length(); i++){
            int valid = (s.charAt(i) - '0') + 10 * (s.charAt(i - 1) - '0');
            tmp = valid >= 10 && valid <=25 ? a + b : a;
            b = a;
            a = tmp;
        }
        return a;
    }

    //空间复杂度进一步降低为O(1)
    //从右边开始dp也是可以的
   public int better(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0){
            num /= 10;
            x = num % 10;
            int tmp = 10*x + y;
            int c = tmp >= 10 && tmp <= 25 ? a + b:a;
            b = a;
            a = c;
            y = x;
        }
            return a;
    }

    public static void main(String[] args) {
        Interview46 test = new Interview46();
        System.out.print(test.translateNum(12258));
    }
}
