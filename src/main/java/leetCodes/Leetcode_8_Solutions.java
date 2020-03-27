package leetCodes;

/**
 * @author ziyuy
 * 提取出字符串中的数字，遇到char类型停止，遇到超过int范围的整数则返回整形最大/最小值 空格也是char类字符
 * 编程思路有问题，但这个题目是真的傻逼
 */
public class Leetcode_8_Solutions {

    class Solution {
        public int myAtoi(String str) {
            int i = 0, j = 0, len = str.length();
            boolean negative = false;
            for (i = 0; i < len; i++) {
                if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                    break;
                } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    negative = str.charAt(i) == '-';
                    i++;
                    break;
                } else if (str.charAt(i) != ' ') {
                    return 0;
                }
            }
            for (j = i; j < len; j++) {
                if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
                    break;
                }
            }
            int ret = 0;
            String num = str.substring(i, j);
            for (int x = 0; x < num.length(); x++) {
                int cur = num.charAt(x) - '0';
                if (negative) {
                    //这里判断溢出的情况和第7题一样
                    if (ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && cur > 8) {
                        return Integer.MIN_VALUE;
                    }
                    ret = ret * 10 - cur;
                } else {
                    if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                        return Integer.MAX_VALUE;
                    }
                    ret = ret * 10 + cur;
                }
            }
            return ret;
        }
    }
}

