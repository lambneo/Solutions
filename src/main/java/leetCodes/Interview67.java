package leetCodes;

public class Interview67 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        char[] chars = str.toCharArray();
        int i = 0, len = chars.length;
        long res = 0;
        boolean neg = false;
        while (chars[i] == ' ') i++;
        if (chars[i] == '-'){
            neg = true;
            i++;
        }
        else if (chars[i] == '+')
            i++;

        for (;i < len; i++){
            if (chars[i] <= '9' && chars[i] >= '0'){
                res = res * 10 + (chars[i] - '0');
                if (res > Integer.MAX_VALUE) {
                     if (neg)
                         return Integer.MIN_VALUE;
                     else
                         return Integer.MAX_VALUE;
                }
            }
            else break;
        }
        res = ((neg)?-1:1) * res;
        return (int) res;
    }

    public static void main(String[] args) {
        Interview67 test = new Interview67();
        System.out.print(test.strToInt(" "));
    }
}
