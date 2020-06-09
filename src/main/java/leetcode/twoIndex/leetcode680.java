package leetcode.twoIndex;

public class leetcode680 {
    /**
     * 在判断双指针时，遇到不符合条件的指针时，考虑删除掉当前两个指针中一个后剩余的数组是否是回文即可
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int i = -1, j = s.length();
        while (++i < --j){
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j-1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j){
        while (i < j){
            if (s.charAt(i++) !=s.charAt(j--))
                return false;
        }
        return true;
    }
}
