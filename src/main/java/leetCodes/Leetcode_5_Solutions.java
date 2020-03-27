package leetCodes;

/**
 * @author ziyuy
 * 寻找最长回文子串，即寻找字符串与其逆序串的最长公共子串,但需注意镜像副本问题
 * 注意，输入为空的情况要讨论
 * 自己写的捞逼版本
 */
public class Leetcode_5_Solutions {
    public static String longestPalindrome(String s) {
        int[][] matrix = new int[s.length()][s.length()];
        int lenMax = 0;
        int Dest = 0;
        String Palindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                Boolean verify = true;
                if (s.charAt(i) == s.charAt(s.length() - j - 1)) {
                    if (i > 0 && j > 0 && matrix[i - 1][j - 1] >= 1) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }
                    if (matrix[i][j] > lenMax) {
                        for (int l = 0; l < matrix[i][j]; l++) {
                            if (s.charAt(i - matrix[i][j] + 1 + l) != s.charAt(i - l)) {
                                verify = false;
                            }
                        }   // 验证本次取得的回文不是镜像副本
                        if (verify) {
                            lenMax = matrix[i][j];
                            Dest = i;
                        }
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int k = 0; k < lenMax; k++) {
            Palindrome = String.copyValueOf(s.toCharArray(), Dest - lenMax + 1, lenMax);
        }
        return Palindrome;
    }


    //Function to reverse the String

    //WARNNING!:this function malfunctions because it will alter the char value!

    //	public static String ReverseStr(String n) {
//		char[] s = n.toCharArray();
//		char[] sReverse = new char[s.length];
//		for(int i = 0; i < s.length; i++) {
//			sReverse[s.length - i - 1]= s[i];
//		}
//		return sReverse.toString();
//		
//	}
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String str = "abacdfgdcabaaaaaaaaaaaaaaa";
        System.out.println(longestPalindrome1(str));
    }
}
