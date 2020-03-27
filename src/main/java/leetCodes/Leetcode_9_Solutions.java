package leetCodes;


public class Leetcode_9_Solutions {

    /**
     * @author ziyuy
     * @target 求回文数
     * Note:若不考虑空间复杂度和时间复杂度，此即为求回文子串的翻版
     */

    public boolean isPalindrome(int x) {
        boolean flag = true;
        if (x < 0) {
            return false;
        } else {
            String str = Integer.toString(x);
            int len = str.length();
            int i = 0;
            while (i < len / 2) {
                if (str.charAt(i) != str.charAt(len - i - 1)) {
                    flag = false;
                    break;
                }
                i++;
            }

        }

        return flag;

    }

}
